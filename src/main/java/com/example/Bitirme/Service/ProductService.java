package com.example.Bitirme.Service;

import com.example.Bitirme.Entities.ProductEntity;
import com.example.Bitirme.Response.ProductResponse;
import com.example.Bitirme.dto.ProductDto;
import com.example.Bitirme.request.CreateProductRequest;
import com.example.Bitirme.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAll();
    ProductEntity addProduct(CreateProductRequest createProductRequest);
    ProductResponse editProduct(long id, UpdateProductRequest request);
    Boolean deleteProduct(long id);
}
