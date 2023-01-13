package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entities.User;
import helper.FactoryProvider;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("user_email");
		String pwd = request.getParameter("user_password");
		
		UserDao userDao = new UserDao(FactoryProvider.getFactory());
		User user = userDao.getUserByEmailPwd(email, pwd);
		HttpSession httpSession = request.getSession();
		if(user == null) {
			httpSession.setAttribute("message", " Incorrect credential for" + email);
			response.sendRedirect("login.jsp");	
			return;
		}
		else {
			httpSession.setAttribute("current_user", user);
			if(user.getUserType().equals("admin")) {
				response.sendRedirect("admin.jsp");
			}
			else {
				response.sendRedirect("index.jsp");
			}
		}
	}

}
