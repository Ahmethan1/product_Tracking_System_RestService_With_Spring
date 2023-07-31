package com.example.Bitirme.Service;

import com.example.Bitirme.Entities.CategoryEntity;
import com.example.Bitirme.Entities.ProductEntity;
import com.example.Bitirme.Response.CategoryResponse;
import com.example.Bitirme.Response.ProductResponse;
import com.example.Bitirme.request.CreateCategoryRequest;
import com.example.Bitirme.request.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAll();
    CategoryEntity addCategory(CreateCategoryRequest createCategoryRequest);
    CategoryResponse editCategory(long id , UpdateCategoryRequest category);
    Boolean deleteCategory(long id);
}
