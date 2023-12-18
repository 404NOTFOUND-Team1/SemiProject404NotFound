package com.nf.not404found.admin.event.model.dto;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdminEventDTO {
    private int eventCode;
    private int productCode;
    private String name;
    private int discountRate;
    private Date registEventDate;
    private Date startDate;
    private Date endDate;
    private String status;
}
