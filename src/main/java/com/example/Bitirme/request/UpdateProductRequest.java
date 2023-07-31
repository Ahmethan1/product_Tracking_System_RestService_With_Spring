package com.example.Bitirme.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UpdateProductRequest {

    private String urunAd;
    private Long urunKod;
    private Long categoryId;
    private int urunStok;
}
