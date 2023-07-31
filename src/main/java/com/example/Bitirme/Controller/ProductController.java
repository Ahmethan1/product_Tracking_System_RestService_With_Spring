package com.example.Bitirme.Controller;

import com.example.Bitirme.Entities.ProductEntity;
import com.example.Bitirme.Response.ProductResponse;
import com.example.Bitirme.Service.Impl.ProductServiceImpl;
import com.example.Bitirme.request.CreateProductRequest;
import com.example.Bitirme.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;
    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductResponse>> getAll(){
        List<ProductResponse> productResponses= productService.getAll();
        return ResponseEntity.ok(productResponses);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductEntity> addEntity(@RequestBody CreateProductRequest request) {
        ProductEntity productEntity=productService.addProduct(request);
        return ResponseEntity.ok(productEntity);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<ProductResponse> editProduct(@PathVariable("id") Long id,@RequestBody UpdateProductRequest request) {
        ProductResponse productResponse=productService.editProduct(id,request);
        return ResponseEntity.ok(productResponse);
    }
    @DeleteMapping("/removeProduct/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") long id){
        Boolean a = productService.deleteProduct(id);
        return ResponseEntity.ok(a);
    }

}
