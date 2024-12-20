package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Customer;
import mypackage.model.InvoiceDetail;

public interface IInvoiceDetailRepository  extends JpaRepository<InvoiceDetail, Integer> {

}
