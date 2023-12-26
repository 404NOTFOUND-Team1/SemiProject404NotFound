package com.nf.not404found.product.model.service;

import com.nf.not404found.main.model.dto.MainPageProductDTO;
import com.nf.not404found.product.model.dao.ProductMapper;
import com.nf.not404found.product.model.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductMapper mapper;
    public ProductService(ProductMapper mapper) {
        this.mapper = mapper;
    }

    public List<MainPageProductDTO> getProduct(String value) {
        return mapper.getProduct(value);
    }

    public List<MainPageProductDTO> getFurniture() {
        List<MainPageProductDTO> sad = mapper.getFurniture();

        log.info("============================== sad : " + sad);

        return sad;
    }

    public List<MainPageProductDTO> getMaterial() {
        return mapper.getMaterial();
    }

    public List<MainPageProductDTO> getNewProduct() {
        return mapper.getNewProduct();
    }

    public List<MainPageProductDTO> getBest() {
        return mapper.getBest();
    }
}
