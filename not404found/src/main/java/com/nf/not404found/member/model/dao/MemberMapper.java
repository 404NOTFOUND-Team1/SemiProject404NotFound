package com.nf.not404found.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    @Select("SELECT COUNT(*) FROM accounts WHERE accounts.id = #{id}")
    int usernameExists(String id);

    @Insert("INSERT INTO email_check(id,pwd_key) VALUES (#{id},#{pwd_key})")
    boolean checkEmail(String id, String pwd_key);

    @Select("SELECT COUNT(*) FROM email_check WHERE id = #{id} AND pwd_key = #{pwd_key}")
    boolean checkCode(String id, String pwdCode);
}
