package com.example.Bitirme.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {

    private Long Id;
    private String urunAd;
    private Long urunKod;
    private Long categoryId;
    private int urunStok;
}
