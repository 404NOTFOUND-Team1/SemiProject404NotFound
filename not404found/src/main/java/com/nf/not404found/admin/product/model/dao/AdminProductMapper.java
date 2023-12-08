package com.nf.not404found.admin.product.model.dao;

import com.nf.not404found.admin.product.model.dto.AdminProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminProductMapper {
    List<AdminProductDTO> selectConditionProduct(AdminProductDTO product);

    List<AdminProductDTO> selectAllProduct();
}
