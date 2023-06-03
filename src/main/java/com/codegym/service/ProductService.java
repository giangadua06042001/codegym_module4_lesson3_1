package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements  IProduct{
    private static final Map<Integer,Product> products;
    static {
        products=new HashMap<>();
        products.put(1,new Product(1,"Sua chua nep cam",8000,"hop",200));
         products.put(2,new Product(2,"Sua chua con bo vang",5000,"hop",250));
         products.put(3,new Product(3,"Banh sua",15000,"hop",300));
         products.put(4,new Product(4,"Sua tuoi",7000,"hop",200));
         products.put(5,new Product(5,"Tra sua tran chau",15000,"hop",400));
         products.put(6,new Product(6,"Sua chua huong dua",25000,"hop",100));
         products.put(7,new Product(7,"Sua chua hoa qua",9000,"hop",150));
         products.put(8,new Product(8,"Sua chua ",8000,"hop",300));

    }
    @Override
    public List<Product> fillAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.put(id,product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }

    @Override
    public Product searchName(String name) {
        for (Product products: products.values()) {
            if(products.getNameProduct().equals(name)){
                return products;
            }
        } return null;
    }

}
