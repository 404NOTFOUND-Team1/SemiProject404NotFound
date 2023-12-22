package com.nf.not404found.product.model.service;

import com.nf.not404found.product.model.dao.ProductMapper;
import com.nf.not404found.product.model.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper mapper;
    public ProductService(ProductMapper mapper) {
        this.mapper = mapper;
    }

    public List<ProductDTO> getProduct() {
        return mapper.getProduct();
    }
}
