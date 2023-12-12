package com.nf.not404found.admin.product.model.dao;

import com.nf.not404found.admin.product.model.dto.AdminAttachmentDTO;
import com.nf.not404found.admin.product.model.dto.AdminProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminProductMapper {
    List<AdminProductDTO> selectConditionProduct(AdminProductDTO product);

    List<AdminProductDTO> selectAllProduct();

    int insertProduct(AdminProductDTO thumbnail);

    int insertAttachment(AdminAttachmentDTO adminAttachmentDTO);

    int insertOptions(AdminProductDTO thumbnail);

    List<AdminProductDTO> selectOneProduct(String productName);

    List<AdminProductDTO> selectOneProduct2(Long productCode);
}
