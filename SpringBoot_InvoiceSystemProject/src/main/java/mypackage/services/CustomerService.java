package mypackage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Customer;
import mypackage.repository.ICustomerRepository;

@Service
public class CustomerService {

	@Autowired
	ICustomerRepository custrepo;
	
	public void AddOrUpdateCustomer(Customer c) {
		Customer cust=custrepo.save(c);
	}
	public List<Customer>GetAllCustomers(){
		return custrepo.findAll();
	}
	public Customer GetCustomer(int id) {
		return custrepo.findById(id).get();
	}
	
	public void DeleteCustomer(int id) {
		Customer c=GetCustomer(id);
		custrepo.delete(c);
	}
}
