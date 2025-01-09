package com.jvc.simplecrud.model.rdmProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RdmProduct {
    private long id;
    private String title;
    private String description;
    private double price;
    private int stock;
    private String category;

}