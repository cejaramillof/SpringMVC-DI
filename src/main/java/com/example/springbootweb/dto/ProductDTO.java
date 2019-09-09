package com.example.springbootweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter // lombok
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {

    @JsonIgnore
    private Long id; // Long obj - long primitive

    private String code;
    private String name;
    private String description;
    private Double price;
}
