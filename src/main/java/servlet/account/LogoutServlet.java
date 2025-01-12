package servlet.account;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hủy session khi người dùng đăng xuất
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // Hủy session
            
        }
        // Chuyển hướng về trang đăng nhập hoặc trang chủ
        resp.sendRedirect(req.getContextPath()+"/");
    }
}
