package com.nf.not404found.member.model.dao;

import com.nf.not404found.member.model.dto.LoginUserDTO;
import com.nf.not404found.member.model.dto.PwdFindDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface EmailMapper {

   int insertRandomEmailCode(PwdFindDTO pwdFind);
}
