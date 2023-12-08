package com.nf.not404found.admin.product.model.service;

import com.nf.not404found.admin.product.model.dto.AdminProductDTO;

import java.util.List;
import java.util.Map;

public interface AdminProductService {
    List<AdminProductDTO> selectConditionProduct(AdminProductDTO product);

    List<AdminProductDTO> selectAllProduct();
}
