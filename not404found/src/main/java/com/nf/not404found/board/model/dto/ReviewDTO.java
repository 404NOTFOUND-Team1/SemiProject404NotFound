package com.nf.not404found.board.model.dto;

import com.nf.not404found.account.model.dto.AccountDTO;
import com.nf.not404found.product.model.dto.ProductDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ReviewDTO {

    BoardDTO board;
    ProductDTO product;
    private int recommend_review;
    private int star_rating;
    private int reviewCount;

    public void setPost_code(int post_code) {
        if (this.board == null) {
            this.board = new BoardDTO();
        }
        this.board.setPost_code(post_code);
    }

    public void setCategory_code(int category_code) {
        if (this.board == null || this.board.getBoardCategory() == null) {
            this.board = new BoardDTO();
            this.board.setBoardCategory(new BoardCategoryDTO());
        }
        this.board.getBoardCategory().setCategorycode_board(category_code);
    }

    public void setProduct_code(int product_code) {
        if (this.product == null) {
            this.product = new ProductDTO();
        }
        this.product.setProduct_code(product_code);
    }

    public void setId(String id) {
        if (this.board == null) {
            this.board = new BoardDTO();
        }
        if (this.board.getAccount() == null) {
            this.board.setAccount(new AccountDTO());
        }
        this.board.getAccount().setId(id);
    }
}
