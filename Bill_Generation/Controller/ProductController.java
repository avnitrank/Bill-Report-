package com.example.Bill_Generation.Controller;

import com.example.Bill_Generation.Model.Product;
import com.example.Bill_Generation.Model.ResponseDTO;
import com.example.Bill_Generation.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("saveProduct")
    public ResponseDTO<List<Product>> saveProduct(@RequestBody List<Product> products) {
        return productService.saveProduct(products);
    }

}
