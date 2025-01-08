package servlet.admin.manage_product;

import java.io.IOException;
import java.util.List;

import dao.admin.manage_product.ListLaptopDAO;
import dao.admin.manage_product.ListPeripheralDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Laptop;
import model.Peripheral;

@WebServlet("/adminPage/listProduct")
public class ListProductManageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageLaptop = 1; // Mặc định là trang 1
		int pageSize = 5; // Số sản phẩm trên mỗi trang

		ListLaptopDAO listLaptopdao = new ListLaptopDAO();
		List<Laptop> listLaptop = listLaptopdao.getListLaptopManage(pageLaptop, pageSize);
		
		int totalLaptop = listLaptopdao.getTotalProductCount(); // Tổng số sản phẩm
		int totalPageLaptop = (int) Math.ceil((double) totalLaptop / pageSize); // Tính tổng số trang

		

		req.setAttribute("ListLaptop", listLaptop);
		req.setAttribute("totalPageLaptop", totalPageLaptop);
		req.setAttribute("pageLaptop", pageLaptop);


		
		int pagePeripheral = 1;


		
		ListPeripheralDAO listPeripheralDao= new ListPeripheralDAO();
		List<Peripheral> listPeripheral= listPeripheralDao.getListPeripheralManage(pagePeripheral, pageSize);
		
		int totalPeripheral = listPeripheralDao.getTotalProductCount(); // Tổng số sản phẩm
		int totalPagePeripheral = (int) Math.ceil((double) totalPeripheral / pageSize); // Tính tổng số trang

		

		req.setAttribute("ListPeripheral", listPeripheral);
		req.setAttribute("totalPagePeripheral", totalPagePeripheral);
		req.setAttribute("pagePeripheral", pagePeripheral);
		
		req.setAttribute("dynamicSection", "componentsAdmin/manageProduct.jsp");
		req.setAttribute("activeProduct", "active");


		req.getRequestDispatcher("/adminPage.jsp").forward(req, resp);
	}

}
