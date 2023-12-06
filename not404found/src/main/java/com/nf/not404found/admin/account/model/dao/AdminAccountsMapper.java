package com.nf.not404found.admin.account.model.dao;

import com.nf.not404found.admin.account.model.dto.AdminAccountDTO;
import com.nf.not404found.admin.account.model.dto.AdminBlackDTO;
import com.nf.not404found.admin.account.model.dto.AdminDormantDTO;
import org.apache.ibatis.annotations.Mapper;

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
}
