package BT_buoi25;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BT_buoi25", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// Forward request to login.jsp
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username.equals("admin") && password.equals("123456789")) {
			System.out.println("Successfully login!");
		}
		else {
			System.out.println("Failed login!");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
