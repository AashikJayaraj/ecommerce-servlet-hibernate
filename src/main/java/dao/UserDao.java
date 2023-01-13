package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entities.User;

public class UserDao {
	private SessionFactory factory;
	public UserDao(SessionFactory factory){
		this.factory = factory;
	}
	public User getUserByEmailPwd(String email, String password) {
		User user = null;
		try {
			String query = "from User where email=:e and password=:p";
			Session s = this.factory.openSession();
			Query q = s.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			user = (User) q.uniqueResult();
			s.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}
}
