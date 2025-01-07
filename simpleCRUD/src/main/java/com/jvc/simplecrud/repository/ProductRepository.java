package com.jvc.simplecrud.repository;

import com.jvc.simplecrud.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j

public class ProductRepository {

    public List<Product> products = new ArrayList<>();

    public List<Product> findAll() {

        return products;
    }


    public Product findByID(int id) {
        return products.get(id);
    }


    public Product save(Product product) {
        products.add(product);
        return product;
    }

    public Product update(Product product) {
       int index = products.indexOf(product);

        Product updatedProduct = new Product();
        updatedProduct.setId(product.getId());
        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setDescrption(product.getDescrption());
        updatedProduct.setStock(product.getStock());

        products.set(index, updatedProduct);

        return updatedProduct;
    }

    public void delete(int id) {
       /* for (Product product : products) {

            if (product.getId() == id) {
                products.remove(product);
            }
        }
        */

        products.removeIf(product -> product.getId() == id);
    }

    public void deleteById(int id) {
    }
}
