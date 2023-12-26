package com.nf.not404found.board.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RecommendIcDTO {

    private int r_code;
    private String id;  // AccountsDTO의 id 외래키
    private int post_code;  // InteriorChallengeDTO의 post_code 외래키
    private int r_check;
}
