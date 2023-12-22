package com.nf.not404found.order.model.dao;


import com.nf.not404found.order.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    OrderDTO getOrderInfor(String id);

    @Select("SELECT rate FROM coupon WHERE name = #{coupon}")
    Integer getCouponDiscountRate(String coupon);
}
