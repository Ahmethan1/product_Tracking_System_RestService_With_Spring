package com.example.Bitirme.Controller;

import com.example.Bitirme.Entities.CategoryEntity;
import com.example.Bitirme.Response.CategoryResponse;
import com.example.Bitirme.Service.Impl.CategoryServiceImpl;
import com.example.Bitirme.request.CreateCategoryRequest;
import com.example.Bitirme.request.UpdateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl categoryService;
    @GetMapping("/getAllCategory")
    public ResponseEntity<List<CategoryResponse>> getAll(){
        List<CategoryResponse> categoryResponses= categoryService.getAll();
        return ResponseEntity.ok(categoryResponses);
    }
    @PostMapping("/addCategory")
    public ResponseEntity<CategoryEntity> addCategory(@RequestBody CreateCategoryRequest categoryRequest){
        CategoryEntity categoryEntity =categoryService.addCategory(categoryRequest);
        return ResponseEntity.ok(categoryEntity);
    }
    @PutMapping("/editCategory/{id}")
    public  ResponseEntity<CategoryResponse> editCategory(@PathVariable("id") long id, @RequestBody UpdateCategoryRequest updateCategory){
        CategoryResponse category=categoryService.editCategory(id,updateCategory);
        return ResponseEntity.ok(category);
    }
    @DeleteMapping("/removeCategory/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") long id){
        Boolean a = categoryService.deleteCategory(id);
        return ResponseEntity.ok(a);
    }

}
