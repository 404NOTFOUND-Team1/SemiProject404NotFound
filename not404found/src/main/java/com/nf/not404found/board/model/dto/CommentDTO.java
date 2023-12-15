package com.nf.not404found.board.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommentDTO {

    private int comment_code;
    BoardDTO board;
    private String comment_body;
    private Date comment_date;
}
