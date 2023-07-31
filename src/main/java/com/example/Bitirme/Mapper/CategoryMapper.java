package com.example.Bitirme.Mapper;

import com.example.Bitirme.Entities.CategoryEntity;
import com.example.Bitirme.Entities.ProductEntity;
import com.example.Bitirme.Response.CategoryResponse;
import com.example.Bitirme.Response.ProductResponse;
import com.example.Bitirme.request.CreateCategoryRequest;
import com.example.Bitirme.request.CreateProductRequest;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")

public interface CategoryMapper {
    List<CategoryResponse> fromCategoryListToResponseList(List<CategoryEntity> categoryEntities);
    CategoryEntity fromRequestToProductEntity(CreateCategoryRequest request);

    CategoryResponse fromProductEntityToProductResponse(CategoryEntity entity);
}
