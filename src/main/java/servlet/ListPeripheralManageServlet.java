package servlet;

import java.io.IOException;
import java.util.List;

import dao.ListPeripheralDAO;
import entity.Peripheral;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminPage/listPeripheral")
public class ListPeripheralManageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pagePeripheral = 1;
		int pageSize=5;

		String pageParamPeripheral = req.getParameter("pagePeripheral");
		if (pageParamPeripheral  != null) {
			pagePeripheral = Integer.parseInt(pageParamPeripheral); // Chuyển tham số `page` thành số nguyên
		}
		
		ListPeripheralDAO listPeripheralDao= new ListPeripheralDAO();
		List<Peripheral> listPeripheral= listPeripheralDao.getListPeripheralManage(pagePeripheral, pageSize);
		
		
		
		int totalPeripheral = listPeripheralDao.getTotalProductCount(); // Tổng số sản phẩm
		int totalPagePeripheral = (int) Math.ceil((double) totalPeripheral / pageSize); // Tính tổng số trang

		

		req.setAttribute("ListPeripheral", listPeripheral);
		req.setAttribute("totalPagePeripheral", totalPagePeripheral);
		req.setAttribute("pagePeripheral", pagePeripheral);


		req.getRequestDispatcher("/componentsAdmin/managePeripheral.jsp").forward(req, resp);
	}
	

}
