package com.example.Bitirme.Entities;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public" , name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "urun_id")
    private Long id;
    @Column(name = "urun_ad")
    private String urunAd;
    @Column(name = "urun_kod")
    private Long urunKod;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "urun_stok")
    private int urunStok;

}


