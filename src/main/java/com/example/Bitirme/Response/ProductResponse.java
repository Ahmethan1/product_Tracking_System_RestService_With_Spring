package com.example.Bitirme.Response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String urunAd;
    private Long urunKod;
    private Long categoryId;
    private int urunStok;
}
