package com.nf.not404found.main.mainservice;

import com.nf.not404found.main.model.dao.MainPageMapper;
import com.nf.not404found.main.model.dto.MainPageProductDTO;
import com.nf.not404found.product.model.dto.ProductPageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final MainPageMapper mapper;
    public MainService(MainPageMapper mapper){
        this.mapper = mapper;
    }

    public List<MainPageProductDTO> showMainPageProduct() {
        List<MainPageProductDTO> list = mapper.showMainPageProduct();
        for(MainPageProductDTO product : list){
            System.out.println("======"+product.getName()+"======");
            System.out.println(product.getPrice());
            System.out.println(product.getPriority());
            System.out.println(product.getDiscountRate());
            System.out.println(product.getReviewCount());
            System.out.println(product.getDiscountPrice());
            System.out.println("=========================");
        }
        return list;
    }

    public List<ProductPageDTO> getProduct(String name) {
        List<ProductPageDTO> list = mapper.getProduct(name);
        for(ProductPageDTO p : list){
            System.out.println("===="+p.getName()+"====");
            System.out.println(p.getMileage());
            System.out.println(p.getDeliveryCost());
            System.out.println(p.getReviewCount());
            System.out.println(p.getPrice());
            System.out.println(p.getColor());
            System.out.println(p.getProductCode());
        }
        List<String> list2 = mapper.getProductColor(list.get(0).getProductCode());
        System.out.println(list2);
        return list;

    }
}
