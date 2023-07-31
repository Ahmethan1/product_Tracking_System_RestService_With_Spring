package com.example.Bitirme.Repository;

import com.example.Bitirme.Entities.ProductEntity;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity , Long> {
    //List<ProductEntity> findByName(String urunAd);


}
