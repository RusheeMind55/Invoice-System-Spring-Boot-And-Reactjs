package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Customer;
import mypackage.model.InvoicePayment;

public interface IInvoicePaymentRepository  extends JpaRepository<InvoicePayment, Integer> {

}
