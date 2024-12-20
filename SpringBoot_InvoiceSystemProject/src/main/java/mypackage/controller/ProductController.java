package mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mypackage.model.Customer;
import mypackage.model.Product;
import mypackage.services.ProductService;


@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired 
	ProductService prodService;
	
	@GetMapping("")
	public String ProductView(Model model) {
		Product p =new Product();
		
		model.addAttribute("product",p);
		List<Product>lst=prodService.GetAllProducts();
		model.addAttribute("productlist",lst);
		
		return "Product";
	}
	@PostMapping("")
	public String AddProduct(@ModelAttribute("product") Product p,Model model) {
		
		prodService.AddOrUpdateProduct(p);
		model.addAttribute("message","Proudct Added Successfully");
		Product pr =new Product();
		model.addAttribute("product",pr);
		List<Product>lst=prodService.GetAllProducts();
		model.addAttribute("productlist",lst);
		
		return "Product";
	}
	
	
	@GetMapping("/edit/{id}")
	public String EditView(@PathVariable("id") int id, Model model) {
		Product p =prodService.GetProduct(id);
		
		model.addAttribute("product",p);
		List<Product>lst=prodService.GetAllProducts();
		model.addAttribute("productlist",lst);
		
		return "product-edit";
	}
	
	@PostMapping("/edit")
	public String UpdateProduct(@ModelAttribute("product") Product p,Model model) {
		
		prodService.AddOrUpdateProduct(p);
	 
		
		return "redirect:/product";
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteView(@PathVariable("id") int id, Model model) {
		 
		prodService.DeleteProduct(id);
		return "redirect:/product";
	}
	
	
	@ResponseBody
	@GetMapping("/allproducts")
	public List<Product> getAllProducts() {
		
		 
		return  prodService.GetAllProducts();

	}
	@ResponseBody
	@GetMapping("/getproduct/{id}")
	public Product getProduct(@PathVariable("id")int id) {
		
		 
		return  prodService.GetProduct(id);

	}
	
}
