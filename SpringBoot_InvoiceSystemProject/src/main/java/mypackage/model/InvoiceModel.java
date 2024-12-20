package mypackage.model;

import java.util.List;

public class InvoiceModel {

	private int customer_id;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	private String invoice_date;
	private float total_amount;
	public InvoiceModel(int customer_id, String invoice_date, float total_amount, List<InvoiceProductModel> products) {
		super();
		this.customer_id = customer_id;
		this.invoice_date = invoice_date;
		this.total_amount = total_amount;
		this.products = products;
	}
	private List<InvoiceProductModel> products;
	public InvoiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public String getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}
	public float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	public List<InvoiceProductModel> getProducts() {
		return products;
	}
	public void setProducts(List<InvoiceProductModel> products) {
		this.products = products;
	}
}
