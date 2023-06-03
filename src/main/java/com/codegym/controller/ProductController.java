package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProduct;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProduct product=new ProductService();
    @GetMapping("")
    public String index(Model model){
        List<Product> productList=product.fillAll();
        model.addAttribute("productList",productList);
        return "/index";
    }
    @GetMapping("create")
    public String showFromCreate(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("save")
    public String addProduct( Product products){
        products.setId((int) (Math.random() * 10000));
       product.save(products);
       return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String showFromEdit(@PathVariable int id, Model model){
        model.addAttribute("product",product.findById(id));
        return "/edit";
    }
    @PostMapping("update")
    public String updateProduct(Product products){
        product.updateProduct(products.getId(),products);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String ShowDelete(@PathVariable int id,Model model){
        model.addAttribute("product",   product.findById(id));
        return "/delete";
    }
    @PostMapping("delete")
    public  String delete(Product products, RedirectAttributes redirectAttributes){
     product.remove(products.getId());
     redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
     return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String showView(@PathVariable int id,Model model){
        model.addAttribute("product",product.findById(id));
        return "/view";

    }
    @GetMapping("/search")
    public String showSearch(Model model){
        model.addAttribute("product",new Product());
        return "/search";
    }
    @PostMapping("/search/name")
    public String search(Model model,@PathVariable String name){
      model.addAttribute("product",product.searchName(name));
      return "redirect:/product";
    }


}
