package com.nf.not404found.admin.account.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AdminDormantDTO {
    private String id;
    private Date enterDate;
    private String status;
    private String dormantTerminationDate;
}
