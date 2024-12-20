package mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mypackage.model.Customer;
import mypackage.services.CustomerService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("customer")
public class CustomerController {

	
	@Autowired
	CustomerService custService;
	
	
	@GetMapping("")
	public String Index(Model model) {
		
		List<Customer>lst=custService.GetAllCustomers();
		model.addAttribute("customerlist",lst);
		return "Customer";
		
	}
	
	@ResponseBody
	@PostMapping("/add")
	public String AddCustomer(Customer c) {
		custService.AddOrUpdateCustomer(c);
		return "Customer Added Successfully";

	}
	@ResponseBody
	@GetMapping("/getcustomer/{id}")
	public Customer getMethodName(@PathVariable("id")int id) {
		
		Customer c=custService.GetCustomer(id);
		return c;

	}
	@ResponseBody
	@GetMapping("/allcustomers")
	public List<Customer> getAllCustomers() {
		
		 
		return  custService.GetAllCustomers();

	}
	@ResponseBody
	@PostMapping("/update")
	public String UpdateCustomer(Customer c) {
		custService.AddOrUpdateCustomer(c);
		return "Customer Updated Successfully";

	}
	@ResponseBody
	@PostMapping("/delete/{id}")
	public String DeleteCustomer(@PathVariable("id")int id) {
		
		 custService.DeleteCustomer(id);
		 return "Customer Deleted Successfully";

	}
	
}
