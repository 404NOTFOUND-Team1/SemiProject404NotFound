package com.nf.not404found.admin.coupon.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdminCouponDTO {
    private int couponNumber;
    private String name;
    private int rate;
    private String comment;
    private int period;
}
