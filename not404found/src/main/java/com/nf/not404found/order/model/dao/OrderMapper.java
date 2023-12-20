package com.nf.not404found.order.model.dao;


import com.nf.not404found.order.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    OrderDTO getOrderInfor(String id);
}
