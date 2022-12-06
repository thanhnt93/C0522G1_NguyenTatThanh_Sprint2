package com.codegym.be.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodDto {
    private int id;
    private String name;
    private String status;
    private String manufacturing;
    private String content;
    private String price;
    private String image;
}
