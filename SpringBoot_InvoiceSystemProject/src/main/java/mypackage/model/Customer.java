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
@Table(name="tblcustomers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customer_name;
	private String mobile_number;
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("customer")
	private Set<InvoiceDetail> invoices;

	
	public Customer(int customer_id, String customer_name, String mobile_number, String city,
			Set<InvoiceDetail> invoices) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.mobile_number = mobile_number;
		this.city = city;
		this.invoices = invoices;
	}
	public Set<InvoiceDetail> getInvoices() {
		return invoices;
	}
	public void setInvoices(Set<InvoiceDetail> invoices) {
		this.invoices = invoices;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
