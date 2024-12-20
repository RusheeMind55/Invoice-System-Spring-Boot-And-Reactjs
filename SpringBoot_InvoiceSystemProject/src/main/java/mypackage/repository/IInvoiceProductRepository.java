package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Customer;
import mypackage.model.InvoiceProduct;
import mypackage.model.Product;

public interface IInvoiceProductRepository   extends JpaRepository<InvoiceProduct, Integer>{

}
