package com.jvc.simplecrud.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;

}
