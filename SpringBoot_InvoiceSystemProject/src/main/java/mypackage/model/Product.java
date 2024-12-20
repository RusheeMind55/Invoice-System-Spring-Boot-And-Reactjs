package mypackage.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tblproducts")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	private String product_name;
	private float rate;
	private float gst;
	private int stock_quantity;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnoreProperties("product")
	private Set<InvoiceProduct> invoice_products;
	
	public Product(int product_id, String product_name, float rate, float gst, int stock_quantity,
			Set<InvoiceProduct> invoice_products) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.rate = rate;
		this.gst = gst;
		this.stock_quantity = stock_quantity;
		this.invoice_products = invoice_products;
	}
	public Set<InvoiceProduct> getInvoice_products() {
		return invoice_products;
	}
	public void setInvoice_products(Set<InvoiceProduct> invoice_products) {
		this.invoice_products = invoice_products;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getGst() {
		return gst;
	}
	public void setGst(float gst) {
		this.gst = gst;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

}
