package mypackage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.InvoiceDetail;

@RestController
public class InvoiceApiController {

	
	
 
	@PostMapping("/createinvoice")
	public String GenerateInvoice(@RequestBody InvoiceDetail d ) {
		//TODO: process POST request
		System.out.println(d.getInvoice_date()+" "+d.getTotal_amount()+" "+d.getCustomer());
 
		return "Invoice Generated Successfully";
	}
}
