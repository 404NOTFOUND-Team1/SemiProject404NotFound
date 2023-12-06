package com.nf.not404found.admin.account.model.dto;

import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdminAccountDTO {
    private String id;
    private AdminAccountTypeDTO accountTypeName;
    private String name;
    private String email;
    private Date registDate;
    private int payAmount;
    private int mileage;
    private Date lastLogin;
    private int halfYearAccumulatedAmount;
}