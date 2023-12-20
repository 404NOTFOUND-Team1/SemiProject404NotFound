package com.nf.not404found.order.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter@ToString
public class OrderDTO {
    private String grade;
    private float mileageRate;
    private int mileage;
}
