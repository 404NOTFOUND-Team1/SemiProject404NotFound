package com.nf.not404found.board.model.dto;

import lombok.*;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {

    private int post_code;
    BoardCategoryDTO categorycode_board;

    //    AccountsDTO id;

    private String post_title;
    private String post_content;
    private Date post_created_date;
    private Date post_modified_date;
    private int post_views;
}
