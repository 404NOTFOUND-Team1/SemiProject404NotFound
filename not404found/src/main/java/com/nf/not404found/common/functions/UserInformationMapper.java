package com.nf.not404found.common.functions;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInformationMapper {

    @Select("SELECT email FROM accounts WHERE id = #{username}")
    String SearchUserEmail(String username);

    @Select("SELECT name FROM accounts WHERE id = #{username}")
    String SearchUserName(String username);
    @Select("SELECT phone_number FROM accounts WHERE id = #{username}")
    String SearchUserPhone(String username);

    @Select("SELECT address FROM address WHERE id = #{username}")
    String SearchUserAddr(String username);
    @Select("SELECT address_detail FROM address WHERE id = #{username}")
    String SearchUserAddrDetail(String username);
    @Select("SELECT address_name FROM address WHERE id = #{username}")
    String SearchUserAddrName(String username);
    @Select("SELECT zipcode FROM address WHERE id = #{username}")
    String SearchUserAddrZipCode(String username);
    @Select("SELECT COUNT(*) FROM address WHERE id = #{username}")
    int SearchUserAddrCount(String username);

    @Select("SELECT account_status FROM accounts WHERE id = #{username}")
    String SearchUserStatus(String username);
}
