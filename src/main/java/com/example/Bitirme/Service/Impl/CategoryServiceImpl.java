package com.example.Bitirme.Service.Impl;

import com.example.Bitirme.exception.CategoryIdNotFound;
import com.example.Bitirme.exception.CategoryNotFoundException;
import com.example.Bitirme.Entities.CategoryEntity;
import com.example.Bitirme.Mapper.CategoryMapper;
import com.example.Bitirme.Repository.CategoryRepository;
import com.example.Bitirme.Response.CategoryResponse;
import com.example.Bitirme.Service.CategoryService;
import com.example.Bitirme.request.CreateCategoryRequest;
import com.example.Bitirme.request.UpdateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private  final CategoryMapper categoryMapper;
    @Override
    public List<CategoryResponse> getAll() {
        List<CategoryEntity> categoryEntities=categoryRepository.findAll();
        List<CategoryResponse> categoryResponses =categoryMapper.fromCategoryListToResponseList(categoryEntities);
        return categoryResponses;
    }

    @Override
    public CategoryEntity addCategory(CreateCategoryRequest createCategoryRequest) {
        CategoryEntity category1= categoryMapper.fromRequestToProductEntity(createCategoryRequest);
        if (createCategoryRequest.getKategoryAd().isEmpty()){
            throw new CategoryNotFoundException("Category Is Not Found");
        }
        return categoryRepository.save(category1);
    }

    @Override
    public CategoryResponse editCategory(long id, UpdateCategoryRequest category) {
        Optional<CategoryEntity> resultCategory=categoryRepository.findById(id);
        if (category.getKategoryAd().isEmpty() || resultCategory.isPresent()){
            throw new CategoryIdNotFound("Kategori İd Bulunamadı");
        }
        resultCategory.get().setKategoryAd(category.getKategoryAd());
        categoryRepository.save(resultCategory.get());
        return categoryMapper.fromProductEntityToProductResponse(resultCategory.get());
    }

    @Override
    public Boolean deleteCategory(long id) {
        Optional<CategoryEntity> deleteCategory= categoryRepository.findById(id);
        if (deleteCategory.isPresent()){
            categoryRepository.deleteById(id);
            return true;
        }
        throw new CategoryNotFoundException("Category Not Found");
    }


}
