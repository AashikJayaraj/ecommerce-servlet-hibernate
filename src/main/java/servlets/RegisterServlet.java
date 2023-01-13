package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.User;
import helper.FactoryProvider;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("user_name");
			String email = request.getParameter("user_email");
			String password = request.getParameter("user_password");
			String userPhone = request.getParameter("user_phone");
			String address = request.getParameter("user_address");
			String userType = request.getParameter("user_type");
			User user = new User(name, email, password, userPhone, address,userType);
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			int id = (Integer) s.save(user);
			
			tx.commit();
			s.close();
//				user.setUserId(id);

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", name + " succesfully registered");
			response.sendRedirect("register.jsp");
			return;
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
