package com.nf.not404found.admin.product.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdminProductDTO {
    private int productCode;
    private int price;
    private String name;
    private int amount;
    private Date enterDate;
    private String deleteStatus;
    private AdminProductCategoryDTO adminProductCategory;
}
