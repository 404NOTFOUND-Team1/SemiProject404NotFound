package com.nf.not404found.admin.order.model.dto;


import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdminOrderDTO {

    int paymentCode;
    AdminAdressDTO addressList;
    AdminDeliveryDTO deliveryList;
    int price;
    int amount;
    Date paymentDate;
    String deliveryRequest;
    int deliveryCost;
    int couponNumber;

}
