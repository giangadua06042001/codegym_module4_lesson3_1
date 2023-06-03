package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProduct {
    public List<Product>fillAll();
    public  void save(Product product);
    public Product findById(int id);
    public void updateProduct(int id,Product product);
    public void remove(int id);
    public Product searchName(String name);

}
