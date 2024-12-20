package mypackage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblinvoice_products")
public class InvoiceProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_product_id;
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="invoice_id")
	private InvoiceDetail invoice_detail;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;


	public InvoiceProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InvoiceProduct(int invoice_product_id, int quantity, InvoiceDetail invoice_detail, Product product) {
		super();
		this.invoice_product_id = invoice_product_id;
		this.quantity = quantity;
		this.invoice_detail = invoice_detail;
		this.product = product;
	}


	public int getInvoice_product_id() {
		return invoice_product_id;
	}


	public void setInvoice_product_id(int invoice_product_id) {
		this.invoice_product_id = invoice_product_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public InvoiceDetail getInvoice_detail() {
		return invoice_detail;
	}


	public void setInvoice_detail(InvoiceDetail invoice_detail) {
		this.invoice_detail = invoice_detail;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
}
