package com.nf.not404found.board.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttachmentDTO {

    private int attachment_code;
    BoardDTO post_code;
    BoardDTO categorycode_board;
    BoardDTO id;
    private String original_attachment_name;
    private String attachment_name;
    private char is_delete;
}
