package com.nf.not404found.admin.account.model.dao;

import com.nf.not404found.admin.account.model.dto.AdminAccountDTO;
import com.nf.not404found.admin.account.model.dto.AdminBlackDTO;
import com.nf.not404found.admin.account.model.dto.AdminDormantDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminAccountsMapper {
    List<AdminAccountDTO> selectAllAccountsList();

    List<AdminAccountDTO> selectOneAccount(Map<String, String> searchOne);

    List<AdminBlackDTO> selectAllBlackList();

    List<AdminBlackDTO> selectOneBlackList(Map<String, String> searchBlack);

    List<AdminDormantDTO> selectAllDormant();

    List<AdminDormantDTO> selectDormantOne(Map<String, String> dormantOne);

    @Update("UPDATE accounts SET account_status = 'BLACK' WHERE id = #{id}")
    int blacked(String id);

    @Update("UPDATE accounts SET account_status = 'FRIEND' WHERE id = #{id}")
    int whited(String id);


    @Select("SELECT email FROM accounts WHERE id = #{id} ")
    String selectMail(String id);

    @Insert("insert into blacklist (id, blacked_date, reason, email, account_status) VALUES (#{id}, DATE(NOW()), #{reason},#{email},'BLACK')")
    void insertBlackReason(String id, String reason, String email);


    @Delete("DELETE FROM blacklist WHERE id = #{id}")
    void whitedmember(String id);
}
