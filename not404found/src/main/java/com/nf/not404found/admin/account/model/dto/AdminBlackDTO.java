package com.nf.not404found.admin.account.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AdminBlackDTO {
    private String id;
    private Date blackDate;
    private String reason;
    private String email;
}
