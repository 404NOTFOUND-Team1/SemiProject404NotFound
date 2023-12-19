package com.nf.not404found.order.model.service;


import com.nf.not404found.order.model.dao.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    private final OrderMapper mapper;


    public OrderServiceImpl(OrderMapper mapper) {
        this.mapper = mapper;
    }
}
