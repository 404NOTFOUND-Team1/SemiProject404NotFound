package com.nf.not404found.admin.coupon.model.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CouponDTO {
    private int couponNumber;
    private String couponName;
    private int couponRate;
    private String comment;
}
