package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Customer;
import mypackage.model.Product;

public interface IProductRepository   extends JpaRepository<Product, Integer>{

}
