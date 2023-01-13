package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entities.Product;

public class ProductDao {
	
	private SessionFactory factory;
	
	public ProductDao(SessionFactory factory){
		this.factory = factory;
	}
	
	public int addProduct(Product product) {
		Session session = this.factory.openSession();
		Transaction tx = session.beginTransaction();
		int id = (Integer)session.save(product);
		System.out.println("First ID="+id);
		String pid= id+".jpg";
		product.setpPhoto(pid);
		session.update(product);
		tx.commit();
		session.close();
		return id;
	}
	
	public List<Product> getAllProducts(){
		Session session = this.factory.openSession();
		Query q = session.createQuery("from Product");
		List<Product> products = q.list();
		session.close();
		return products;
	}

}
