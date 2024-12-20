package mypackage.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tblinvoice_details")
public class InvoiceDetail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_id;
	private String invoice_date;
	private float total_amount;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("invoice_detail")
	private Set<InvoiceProduct> invoice_products;

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("invoice_detail")
	private Set<InvoicePayment> invoice_payments;

	


	public InvoiceDetail(int invoice_id, String invoice_date, float total_amount, Customer customer,
			Set<InvoiceProduct> invoice_products, Set<InvoicePayment> invoice_payments) {
		super();
		this.invoice_id = invoice_id;
		this.invoice_date = invoice_date;
		this.total_amount = total_amount;
		this.customer = customer;
		this.invoice_products = invoice_products;
		this.invoice_payments = invoice_payments;
	}

	public Set<InvoicePayment> getInvoice_payments() {
		return invoice_payments;
	}

	public void setInvoice_payments(Set<InvoicePayment> invoice_payments) {
		this.invoice_payments = invoice_payments;
	}

	public Set<InvoiceProduct> getInvoice_products() {
		return invoice_products;
	}

	public void setInvoice_products(Set<InvoiceProduct> invoice_products) {
		this.invoice_products = invoice_products;
	}

	public InvoiceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}

