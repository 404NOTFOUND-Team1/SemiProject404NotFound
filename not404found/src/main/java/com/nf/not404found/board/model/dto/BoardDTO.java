package com.nf.not404found.board.model.dto;

import com.nf.not404found.account.model.dto.AccountDTO;
import lombok.*;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {

    private int post_code;
    BoardCategoryDTO categorycode_board;
    AccountDTO id;
    private String post_title;
    private String post_content;
    private Date post_created_date;
    private Date post_modified_date;
    private int post_views;
    private List<AttachmentDTO> attachmentList;
}
