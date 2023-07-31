package com.example.Bitirme.Mapper;

import com.example.Bitirme.Entities.CategoryEntity;
import com.example.Bitirme.Response.CategoryResponse;
import com.example.Bitirme.request.CreateCategoryRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T01:32:56+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public List<CategoryResponse> fromCategoryListToResponseList(List<CategoryEntity> categoryEntities) {
        if ( categoryEntities == null ) {
            return null;
        }

        List<CategoryResponse> list = new ArrayList<CategoryResponse>( categoryEntities.size() );
        for ( CategoryEntity categoryEntity : categoryEntities ) {
            list.add( fromProductEntityToProductResponse( categoryEntity ) );
        }

        return list;
    }

    @Override
    public CategoryEntity fromRequestToProductEntity(CreateCategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setKategoryAd( request.getKategoryAd() );

        return categoryEntity;
    }

    @Override
    public CategoryResponse fromProductEntityToProductResponse(CategoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setKategoryAd( entity.getKategoryAd() );

        return categoryResponse;
    }
}
