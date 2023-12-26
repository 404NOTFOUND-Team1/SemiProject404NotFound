package com.nf.not404found.main.mainservice;

import com.nf.not404found.common.functions.UserInformation;
import com.nf.not404found.main.model.dao.MainPageMapper;
import com.nf.not404found.main.model.dto.MainPageProductDTO;
import com.nf.not404found.product.model.dto.ProductPageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final MainPageMapper mapper;
    private final UserInformation user;
    public MainService(MainPageMapper mapper, UserInformation user){
        this.mapper = mapper;
        this.user = user;
    }

    public List<MainPageProductDTO> showMainPageProduct() {
        return mapper.showMainPageProduct();
    }

    public List<ProductPageDTO> getProduct(String name) {

        List<ProductPageDTO> list = mapper.getProduct(name,user.getName());
        List<String> list2 = mapper.getProductColor(list.get(0).getProductCode());
        list.get(0).setColor(list2);
        return list;

    }

    public List<MainPageProductDTO> getSpecialProduct() {
        return mapper.getSpecialProduct();
    }
}
