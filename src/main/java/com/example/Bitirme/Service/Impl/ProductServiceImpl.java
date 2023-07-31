package com.example.Bitirme.Service.Impl;

import com.example.Bitirme.exception.ProductIdNotFound;
import com.example.Bitirme.exception.ProductNotFoundException;
import com.example.Bitirme.Entities.ProductEntity;
import com.example.Bitirme.Mapper.ProductMapper;
import com.example.Bitirme.Repository.ProductRepository;
import com.example.Bitirme.Response.ProductResponse;
import com.example.Bitirme.Service.ProductService;
import com.example.Bitirme.request.CreateProductRequest;
import com.example.Bitirme.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public List<ProductResponse> getAll() {
        List<ProductEntity> productEntities=productRepository.findAll();
        List<ProductResponse> productResponses = productMapper.fromProductListToResponseList(productEntities);
        return productResponses;
    }

    @Override
    public ProductEntity addProduct(CreateProductRequest createProductRequest) {
        ProductEntity productEntities=productMapper.fromRequestToProductEntity(createProductRequest);
        if (createProductRequest.getUrunAd().isEmpty() || createProductRequest.getUrunStok()== 0 ||
                createProductRequest.getUrunKod()== 0 || createProductRequest.getCategoryId() == 0){
            throw new ProductNotFoundException("Ürün eklenemedi Boş alanlar mevcut");
        }

        return productRepository.save(productEntities);
    }

    @Override
    public ProductResponse editProduct(long id, UpdateProductRequest request) {
        Optional<ProductEntity> resultProduct=productRepository.findById(id);
        if(resultProduct.isPresent()){
            resultProduct.get().setUrunAd(request.getUrunAd());
            resultProduct.get().setUrunKod(request.getUrunKod());
            resultProduct.get().setUrunStok(request.getUrunStok());
            resultProduct.get().setCategoryId(request.getCategoryId());
            productRepository.save(resultProduct.get());
            return productMapper.fromProductEntityToProductResponse(resultProduct.get());
        }
        throw new ProductIdNotFound("Id Bulunamadı");


    }

    @Override
    public Boolean deleteProduct(long id) {
        Optional<ProductEntity> productEntity=productRepository.findById(id);
        if (productEntity.isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        throw new ProductNotFoundException("Category Not Found");
    }
}
