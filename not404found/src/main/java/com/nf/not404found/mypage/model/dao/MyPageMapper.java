package com.nf.not404found.mypage.model.dao;

import com.nf.not404found.mypage.model.dto.AddrDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MyPageMapper {
    @Update("UPDATE accounts SET phone_number = #{phone} WHERE id = #{id}")
    boolean changePhone(String phone,String id);

    @Update("UPDATE accounts SET email = #{email} WHERE id = #{id}")
    boolean changeEmail(String email, String id);
    @Update("UPDATE accounts SET password = #{pwd} WHERE id = #{id}")
    boolean changePwd(String pwd, String id);
    @Insert("INSERT INTO address(id,zipcode,address,address_detail,address_name)" +
            " VALUES (#{id},#{zonecode},#{addr},#{addrDetail},#{name})")
    boolean insertAddr(String addr, String zonecode, String name, String addrDetail, String id);
    List<AddrDTO> selectUserAddr(String id);
    @Delete("DELETE FROM address WHERE id=#{id} AND address_name=#{name}")
    boolean deleteAddr(String name,String id);
}
