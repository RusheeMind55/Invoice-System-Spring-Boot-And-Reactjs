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
@Table(name="tblinvoice_payments")
public class InvoicePayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;
	private String payment_date;
	private String payment_mode;
	private float payment_amount;
	private String payment_description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="invoice_id")
	private InvoiceDetail invoice_detail;

	public InvoicePayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public float getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(float payment_amount) {
		this.payment_amount = payment_amount;
	}

	public String getPayment_description() {
		return payment_description;
	}

	public void setPayment_description(String payment_description) {
		this.payment_description = payment_description;
	}

	public InvoiceDetail getInvoice_detail() {
		return invoice_detail;
	}

	public void setInvoice_detail(InvoiceDetail invoice_detail) {
		this.invoice_detail = invoice_detail;
	}

	public InvoicePayment(int payment_id, String payment_date, String payment_mode, float payment_amount,
			String payment_description, InvoiceDetail invoice_detail) {
		super();
		this.payment_id = payment_id;
		this.payment_date = payment_date;
		this.payment_mode = payment_mode;
		this.payment_amount = payment_amount;
		this.payment_description = payment_description;
		this.invoice_detail = invoice_detail;
	}
}
