package com.example.sale.dao;

import com.example.sale.model.entity.ProductEntity;
import com.example.sale.repo.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDao {

  private final ProductRepo productRepo;

    public ProductDao(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public ProductEntity addProduct(ProductEntity productEntity){
        return this.productRepo.save(productEntity);
    }


    public String delProduct(Integer productId){
        Optional<ProductEntity> pro = this.productRepo.findById(productId);
        if (pro.isPresent()){
            this.productRepo.deleteById(pro.get().getProductId());
            return "DONE";

        }else {
            return "NOT FOUND !!";
        }

    }


    public ProductEntity updateProduct(ProductEntity productEntity){
        return this.productRepo.save(productEntity);
    }

   public ProductEntity getProductEntityByBarcode(String barcode){
        Optional<ProductEntity> o = Optional.ofNullable(this.productRepo.findByBarcode(barcode));
        return o.isPresent() ? o.get() : null;
    }

    public ProductEntity getProductEntityByID(Integer productId){
        Optional<ProductEntity> o = this.productRepo.findById(productId);
        return o.isPresent() ? o.get() : null;
    }

    public List<ProductEntity> getProducts(){
       return this.productRepo.findAll();
    }


}
