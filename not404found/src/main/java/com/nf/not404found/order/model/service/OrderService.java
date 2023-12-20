package com.nf.not404found.order.model.service;


import com.nf.not404found.order.model.dao.OrderMapper;
import com.nf.not404found.order.model.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService{

    private final OrderMapper mapper;
    public OrderService(OrderMapper mapper) {
        this.mapper = mapper;
    }

    public OrderDTO getOrderInfor(String id) {
        return mapper.getOrderInfor(id);
    }
}
