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

@WebServlet("/loadMoreProducts")
public class LoadMoreProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int amount = Integer.parseInt(req.getParameter("productExit"));
        ListPeripheralDAO listPeripheralDAO = new ListPeripheralDAO();
        List<Peripheral> listPeripheral = listPeripheralDAO.getListPeripheral(amount);


        System.out.println("kich hoat load more");
        System.out.println(amount);

        req.setAttribute("ListPeripheralMore", listPeripheral);

 
        req.getRequestDispatcher("components/peripheralMore.jsp").forward(req, resp);
    }
}
