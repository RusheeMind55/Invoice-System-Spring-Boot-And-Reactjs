package mypackage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Product;
import mypackage.repository.IProductRepository;

@Service
public class ProductService {

	@Autowired
	IProductRepository prodrepo;
	
	public Product AddOrUpdateProduct(Product p) {
		Product pr= prodrepo.save(p);
		return pr;
		
	}
	
	public List<Product>GetAllProducts(){
		return prodrepo.findAll();
	}
	
	public Product GetProduct(int id) {
		return prodrepo.findById(id).get();
	}
	
	public void DeleteProduct(int id) {
		Product pr=GetProduct(id);
		prodrepo.delete(pr);
	}
}
