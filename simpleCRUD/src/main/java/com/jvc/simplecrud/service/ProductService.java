package com.jvc.simplecrud.service;
import com.jvc.simplecrud.model.Product;
import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    Product update(Product product);
    void delete(int id);

}
