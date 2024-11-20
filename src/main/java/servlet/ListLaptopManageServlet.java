package servlet;

import java.io.IOException;
import java.util.List;

import dao.ListLaptopDAO;
import entity.Laptop;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/adminPage/listLaptop")
public class ListLaptopManageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageLaptop = 1; // Mặc định là trang 1
		int pageSize = 5; // Số sản phẩm trên mỗi trang

		String pageParamLaptop = req.getParameter("pageLaptop");
		if (pageParamLaptop != null) {
			pageLaptop = Integer.parseInt(pageParamLaptop); // Chuyển tham số `page` thành số nguyên
		}
		ListLaptopDAO listLaptopdao = new ListLaptopDAO();
		List<Laptop> listLaptop = listLaptopdao.getListLaptopManage(pageLaptop, pageSize);
		
		int totalLaptop = listLaptopdao.getTotalProductCount(); // Tổng số sản phẩm
		int totalPageLaptop = (int) Math.ceil((double) totalLaptop / pageSize); // Tính tổng số trang

		

		req.setAttribute("ListLaptop", listLaptop);
		req.setAttribute("totalPageLaptop", totalPageLaptop);
		req.setAttribute("pageLaptop", pageLaptop);
		
		req.getRequestDispatcher("/componentsAdmin/manageLaptop.jsp").forward(req, resp);

	}
	
	
	
	

}
