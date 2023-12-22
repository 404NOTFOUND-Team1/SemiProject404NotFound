package com.nf.not404found.payment.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PaymentMapper {
    /**
     * 유저의 쿠폰 상태를 N으로 만들어주는 쿼리
     * @param id 유저의 ID
     * @return 성공 여부 1 OR 0
     */
    @Update("UPDATE user_coupon SET coupon_status = 'N' WHERE id = #{id}")
    int reduceUserCoupon(String id);

    /**
     * 유저의 마일리지를 감소시키는 쿼리
     * @param id 유저의 ID
     * @param value 감소 시킬 양
     * @return 성공 여부 1 OR 0
     */
    @Update("UPDATE accounts SET mileage = mileage - #{value} WHERE id = #{id}")
    int reduceUserMileage(String id, int value);

    /**
     * 상품의 수량을 감소시키는 쿼리
     * @param productCode 제품 코드
     * @param amount 감소시킬 양
     * @return 성공 여부 1 OR 0
     */
    @Update("UPDATE product SET amount = amount - #{value} WHERE product_code = #{productCode}")
    int reduceProductAmount(int productCode, int amount);
}
