package com.example.Bitirme.Mapper;

import com.example.Bitirme.Entities.ProductEntity;
import com.example.Bitirme.Response.ProductResponse;
import com.example.Bitirme.dto.ProductDto;
import com.example.Bitirme.request.CreateProductRequest;
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
public class ProductMapperImpl implements ProductMapper {

    @Override
    public List<ProductResponse> fromProductListToResponseList(List<ProductEntity> productEntities) {
        if ( productEntities == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( productEntities.size() );
        for ( ProductEntity productEntity : productEntities ) {
            list.add( fromProductEntityToProductResponse( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductEntity fromRequestToProductEntity(CreateProductRequest request) {
        if ( request == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setUrunAd( request.getUrunAd() );
        productEntity.setUrunKod( request.getUrunKod() );
        productEntity.setCategoryId( request.getCategoryId() );
        productEntity.setUrunStok( request.getUrunStok() );

        return productEntity;
    }

    @Override
    public ProductResponse fromProductEntityToProductResponse(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setUrunAd( entity.getUrunAd() );
        productResponse.setUrunKod( entity.getUrunKod() );
        productResponse.setCategoryId( entity.getCategoryId() );
        productResponse.setUrunStok( entity.getUrunStok() );

        return productResponse;
    }

    @Override
    public List<ProductDto> fromProductEntityToProductDto(List<ProductEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( entity.size() );
        for ( ProductEntity productEntity : entity ) {
            list.add( productEntityToProductDto( productEntity ) );
        }

        return list;
    }

    protected ProductDto productEntityToProductDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( productEntity.getId() );
        productDto.setUrunAd( productEntity.getUrunAd() );
        productDto.setUrunKod( productEntity.getUrunKod() );
        productDto.setCategoryId( productEntity.getCategoryId() );
        productDto.setUrunStok( productEntity.getUrunStok() );

        return productDto;
    }
}
