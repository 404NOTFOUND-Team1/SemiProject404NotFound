package com.nf.not404found.admin.product.model.service;

import com.nf.not404found.admin.product.model.dto.AdminProductDTO;
import com.nf.not404found.common.exception.admin.ThumbnailRegistException;

import java.util.List;
import java.util.Map;

public interface AdminProductService {
    public List<AdminProductDTO> selectConditionProduct(AdminProductDTO product);
    public List<AdminProductDTO> selectAllProduct();
    public void insertProduct(AdminProductDTO thumbnail) throws ThumbnailRegistException;
}
