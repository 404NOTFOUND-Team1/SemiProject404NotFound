package com.nf.not404found.admin.coupon.model.dao;


import com.nf.not404found.admin.coupon.model.dto.AdminCouponDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminCouponMapper {

    int insertCoupon(AdminCouponDTO coupon);

    List<AdminCouponDTO> selectAllCoupon();
}
