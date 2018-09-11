package dt.b190043.demoproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int productId;
	protected String brand;
	protected String model;
	protected float mrp;
	protected boolean warranty;
	protected int warrantyInMonths;
	
	@ManyToOne(cascade=CascadeType.ALL)
	protected User user;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public boolean isWarranty() {
		return warranty;
	}

	public void setWarranty(boolean warranty) {
		this.warranty = warranty;
	}

	public int getWarrantyInMonths() {
		return warrantyInMonths;
	}

	public void setWarrantyInMonths(int warrantyInMonths) {
		this.warrantyInMonths = warrantyInMonths;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
