package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	private int pQuantity;
	private String pName;
	@Column(length=1000)
	private String pDesc;
	private String pPhoto;
	private int price;
	
	public Product(int pQuantity, String pName, String pDesc, int price) {
		super();
		this.pQuantity = pQuantity;
		this.pName = pName;
		this.pDesc = pDesc;
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public String getpPhoto() {
		return pPhoto;
	}

	public void setpPhoto(String pPhoto) {
		this.pPhoto = pPhoto;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	
	
}
