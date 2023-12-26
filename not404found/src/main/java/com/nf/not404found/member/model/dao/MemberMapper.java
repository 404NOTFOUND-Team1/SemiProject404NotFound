package com.nf.not404found.member.model.dao;

import com.nf.not404found.member.model.dto.LoginUserDTO;
import com.nf.not404found.member.model.dto.PwdFindDTO;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;

@Mapper
public interface MemberMapper {

    @Select("SELECT COUNT(*) FROM accounts WHERE accounts.id = #{id}")
    int usernameExists(String id);

    @Insert("INSERT INTO email_check(id,pwd_key) VALUES (#{id},#{pwd_key})")
    boolean checkEmail(String id, String pwd_key);

    @Select("SELECT COUNT(*) FROM email_check WHERE id = #{id} AND pwd_key = #{pwdCode}")
    int checkCode(String id, String pwdCode);

    @Insert("INSERT INTO accounts (id,password,name,email,phone_number,regist_date,last_login,account_status)" +
            "VALUES (#{id},#{pwd},#{name},#{email},#{phone},now(),now(),null)")
    boolean createMember(String id, String email, String pwd, String name, String phone);


    LoginUserDTO findId(String username);

//    @Update("UPDATE accounts SET mileage = 0, account_status = 0 WHERE id = #{username}")
//    int updateAccountStatus(@Param("username") String username);
    @Update("UPDATE former_members SET former_date = #{deleteDate} WHERE email = #{userEmail}")
    int updateAccountStatus(@Param("userEmail") String userEmail, @Param("deleteDate") LocalDate deleteDate);

    @Delete("DELETE FROM accounts WHERE id = #{username}")
    int deleteAccount(@Param("username") String username);
}
