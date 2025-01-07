package com.jvc.simplecrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private long id;
    private String name;
    private String descrption;
    private double price;
    private int stock;

}
