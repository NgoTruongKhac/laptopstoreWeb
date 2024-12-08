package servlet;

import java.io.IOException;

import dao.EditPeripheralDAO;
import entity.Peripheral;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detailPeripheral")

public class DetailPeripheralServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int PeripheralId=Integer.parseInt(req.getParameter("productId"));
		
		EditPeripheralDAO peripheralDao=new EditPeripheralDAO();
		
		Peripheral peripheral=peripheralDao.getPeripheral(PeripheralId);
		
		req.setAttribute("Peripheral", peripheral);
		
		req.getRequestDispatcher("detailPeripheral.jsp").forward(req, resp);
		
	}
	
	
	
	

}
