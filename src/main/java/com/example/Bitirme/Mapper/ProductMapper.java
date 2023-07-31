package com.example.Bitirme.Mapper;

import com.example.Bitirme.Entities.ProductEntity;
import com.example.Bitirme.Response.ProductResponse;
import com.example.Bitirme.dto.ProductDto;
import com.example.Bitirme.request.CreateProductRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ProductMapper {
    List<ProductResponse> fromProductListToResponseList(List<ProductEntity> productEntities);
    ProductEntity fromRequestToProductEntity(CreateProductRequest request);
    ProductResponse fromProductEntityToProductResponse(ProductEntity entity);
    List<ProductDto> fromProductEntityToProductDto(List<ProductEntity> entity);



}
