package dao.cart;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.CartItem;
import model.Product;

public class ListCartCookieDAO {

	private int cartId;
	private List<Cart> cartList;

	public ListCartCookieDAO(HttpServletRequest req) throws UnsupportedEncodingException {
		this.cartId = 1;
		this.cartList = listCartCookie(req);
	}

	public List<Cart> listCartCookie(HttpServletRequest req) throws UnsupportedEncodingException {

		Cookie[] cookies = req.getCookies();

		List<Cart> cartList = new ArrayList<Cart>();
		// Đọc cookie "cart" nếu đã tồn tại
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("cart".equals(cookie.getName())) {
					String cartData = URLDecoder.decode(cookie.getValue(), "UTF-8");
					String[] items = cartData.split(";");

					for (String item : items) {
						if (!item.isEmpty()) {
							String[] parts = item.split(",");
							int storedProductId = Integer.parseInt(parts[0]);
							int storedQuantity = Integer.parseInt(parts[1]);
							cartList.add(new Cart(cartId++, 0, storedProductId, storedQuantity));
						}
					}
				}
			}
		}
		return cartList;
	}

	public void addToCart(int productId, HttpServletResponse resp) throws UnsupportedEncodingException {

		boolean productExists = false;
		for (Cart cart : cartList) {
			if (cart.getProductId() == productId) {
				cart.setQuantity(cart.getQuantity() + 1);
				productExists = true;
				break;
			}
		}

		if (!productExists) {
			cartList.add(new Cart(cartId++, 0, productId, 1));
		}

		// Lưu lại giỏ hàng vào cookie
		StringBuilder cartData = new StringBuilder();
		for (Cart cart : cartList) {
			cartData.append(cart.getProductId()).append(",").append(cart.getQuantity()).append(";");
		}

		Cookie cartCookie = new Cookie("cart", URLEncoder.encode(cartData.toString(), "UTF-8"));
		cartCookie.setMaxAge(7 * 24 * 60 * 60); // Lưu trong 7 ngày
		resp.addCookie(cartCookie);

	}

	public int cartCount() throws UnsupportedEncodingException {

		return cartList.stream().mapToInt(Cart::getQuantity).sum();
	}

	public void deleteCart(int cartId, HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {

		// Xóa sản phẩm khỏi danh sách giỏ hàng
		cartList.removeIf(cart -> cart.getCartId() == cartId);

		StringBuilder cartData = new StringBuilder();
		for (Cart cart : cartList) {
			cartData.append(cart.getProductId()).append(",").append(cart.getQuantity()).append(";");
		}

		Cookie cartCookie = new Cookie("cart", URLEncoder.encode(cartData.toString(), "UTF-8"));
		cartCookie.setMaxAge(7 * 24 * 60 * 60); // Lưu trong 7 ngày
		resp.addCookie(cartCookie);

		// In ra giỏ hàng đã được cập nhật

	}

	public List<CartItem> getCartItemsFromCookie() throws IOException {

		// Lấy danh sách productId từ cartList
		List<Integer> productIds = cartList.stream().map(Cart::getProductId).toList();
	

		// Truy vấn cơ sở dữ liệu để lấy thông tin sản phẩm
		ListProductCookieDAO productDAO = new ListProductCookieDAO();
		List<Product> products = productDAO.getProductsByIds(productIds);

		// Tạo danh sách CartItem
		List<CartItem> cartItems = new ArrayList<>();
		for (Cart cart : cartList) {
			for (Product p : products) {
				if (cart.getProductId() == p.getProductId()) {
					cartItems.add(new CartItem(cart.getCartId(), p.getProductId(), cart.getQuantity(), p.getName(),
							p.getImage(), p.getPrice(), p.getType()));
				}
			}
		}

		return cartItems;
	}

	public List<CartItem> getCartItemsFromCookie(String[] productIdArr) throws IOException {

	
		
		// Lấy danh sách productId từ cartList
		List<Integer> productIds = Arrays.stream(productIdArr).map(Integer::parseInt).collect(Collectors.toList());

	
		// Truy vấn cơ sở dữ liệu để lấy thông tin sản phẩm
		ListProductCookieDAO productDAO = new ListProductCookieDAO();
		List<Product> products = productDAO.getProductsByIds(productIds);

		// Tạo danh sách CartItem
		List<CartItem> cartItems = new ArrayList<>();
		for (Cart cart : cartList) {
			for (Product p : products) {
				if (cart.getProductId() == p.getProductId()) {
					cartItems.add(new CartItem(cart.getCartId(), p.getProductId(), cart.getQuantity(), p.getName(),
							p.getImage(), p.getPrice(), p.getType()));
				}
			}
		}

		return cartItems;
	}

	public void updateQuantityCart(int cartId, int quantity, HttpServletResponse resp)
			throws UnsupportedEncodingException {

		for (Cart cart : cartList) {
			if (cart.getCartId() == cartId) {
				cart.setQuantity(quantity);
			}
		}
		StringBuilder cartData = new StringBuilder();
		for (Cart cart : cartList) {
			cartData.append(cart.getProductId()).append(",").append(cart.getQuantity()).append(";");
		}

		Cookie cartCookie = new Cookie("cart", URLEncoder.encode(cartData.toString(), "UTF-8"));
		cartCookie.setMaxAge(7 * 24 * 60 * 60); // Lưu trong 7 ngày
		resp.addCookie(cartCookie);
	}

}
