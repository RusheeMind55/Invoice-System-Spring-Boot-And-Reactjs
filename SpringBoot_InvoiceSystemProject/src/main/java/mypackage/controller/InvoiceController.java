package mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mypackage.model.InvoiceDetail;
import mypackage.model.InvoiceProduct;
import mypackage.services.InvoiceService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("invoice")
public class InvoiceController {

	@Autowired
	InvoiceService invService;
	
	@GetMapping("")
	public String InvoiceView() {
		return "Invoice";
	}
	@GetMapping("/new-invoice")
	public String NewInvoiceView() {
		return "NewInvoice";
	}
	
	@ResponseBody
	@PostMapping("/generate-invoice")
	public String GenerateInvoice(@RequestBody InvoiceDetail d ) {
		//TODO: process POST request
//		System.out.println(d.getInvoice_date()+" "+d.getTotal_amount()+" "+d.getCustomer().getCustomer_id());
//		for(InvoiceProduct p : d.getInvoice_products())
//		{
//			System.out.println(p.getProduct().getProduct_id()+" "+p.getQuantity());
//		}
		invService.GenerateNewInvoice(d);
		return "Invoice Generated Successfully";
	}
	
	
	
	
//	@ResponseBody
//	@PostMapping("/generate-invoice")
//	public String GenerateInvoice(@RequestBody InvoiceModel d ) {
//		//TODO: process POST request
//		System.out.println(d.getInvoice_date()+" "+d.getTotal_amount()+" "+d.getCustomer_id());
//		for(InvoiceProductModel p : d.getProducts())
//		{
//			System.out.println(p.getProduct_id()+" "+p.getQuantity());
//		}
//		return "Invoice Generated Successfully";
//	}
}
