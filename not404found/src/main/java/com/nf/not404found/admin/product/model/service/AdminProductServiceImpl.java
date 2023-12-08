package com.nf.not404found.admin.product.model.service;


import com.nf.not404found.admin.product.model.dao.AdminProductMapper;
import com.nf.not404found.admin.product.model.dto.AdminProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AdminProductServiceImpl implements AdminProductService{

    private final AdminProductMapper mapper;

    public AdminProductServiceImpl(AdminProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<AdminProductDTO> selectConditionProduct(AdminProductDTO product) {
        log.info("서비스 왔냐 ======================================================>");

        List<AdminProductDTO> productList1 = mapper.selectConditionProduct(product);

        log.info("잘들어갔냐 ============================================>>");

        return productList1;
    }

    @Override
    public List<AdminProductDTO> selectAllProduct() {
        log.info("전체 상품 서비스 왔냐 ===================================>");

        List<AdminProductDTO> productList = mapper.selectAllProduct();

        log.info("전체 상품 잘 들어갔냐 ====================================================");

        return productList;
    }
}
