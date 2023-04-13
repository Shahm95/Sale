package com.example.sale.controller;

import com.example.sale.dao.ProductDao;
import com.example.sale.model.entity.ProductEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/products")
@RestController
public class ProductController {

    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @PostMapping(path = "/add-product")
    public ProductEntity addProduct(@RequestBody ProductEntity productEntity){
        return this.productDao.addProduct(productEntity);
    }

    @GetMapping(path = "/del-product")
    public String delProduct(@RequestParam Integer productId){
        return this.productDao.delProduct(productId);
    }

    @PostMapping(path = "/update-product")
    public ProductEntity updateProduct(@RequestBody ProductEntity productEntity){
        return this.productDao.updateProduct(productEntity);
    }

    @GetMapping(path = "/get-product-by-barcode")
    public ProductEntity getProductEntityByBarcode(@RequestParam String barcode){
        return this.productDao.getProductEntityByBarcode(barcode);
    }

    @GetMapping(path = "/get-product-by-id")
    public ProductEntity getProductEntityByID(@RequestParam Integer productId){
        return this.productDao.getProductEntityByID(productId);
    }
    @GetMapping(path = "/get-products")
    public List<ProductEntity> getProducts(){
        return this.productDao.getProducts();
    }



}
