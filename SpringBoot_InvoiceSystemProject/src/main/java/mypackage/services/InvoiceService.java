package mypackage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Customer;
import mypackage.model.InvoiceDetail;
import mypackage.model.InvoiceProduct;
import mypackage.model.Product;
import mypackage.repository.IInvoiceDetailRepository;
import mypackage.repository.IInvoiceProductRepository;

@Service
public class InvoiceService {

	
	@Autowired
	IInvoiceDetailRepository invoicerepo;

	@Autowired
	IInvoiceProductRepository invoideprodrepo;
	
	public void GenerateNewInvoice(InvoiceDetail d) {
		Customer c=new Customer(d.getCustomer().getCustomer_id(), d.getCustomer().getCustomer_name(), null, null, null);
		InvoiceDetail dt=new InvoiceDetail(0, d.getInvoice_date(), d.getTotal_amount(), c, null, null);
		InvoiceDetail idetail=invoicerepo.save(dt);
		
		for(InvoiceProduct p : d.getInvoice_products()) {
			Product pr=new Product(p.getProduct().getProduct_id(), p.getProduct().getProduct_name(), 0, 0, 0, null);
			InvoiceProduct iprod=new InvoiceProduct(0, p.getQuantity(), idetail, pr);
			invoideprodrepo.save(iprod);
		}
	}
}
