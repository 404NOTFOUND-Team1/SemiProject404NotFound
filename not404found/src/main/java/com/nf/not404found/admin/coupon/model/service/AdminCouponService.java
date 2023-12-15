package com.nf.not404found.admin.coupon.model.service;

import com.nf.not404found.admin.common.exception.CouponInsertException;
import com.nf.not404found.admin.coupon.model.dto.AdminCouponDTO;

import java.util.List;

public interface AdminCouponService {
    void insertCoupon(AdminCouponDTO coupon) throws CouponInsertException;

    List<AdminCouponDTO> selectAllCoupon();
}
