package com.nf.not404found.member.model.service;


import com.nf.not404found.member.model.dao.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberMapper mapper;
    public MemberService(MemberMapper mapper){
        this.mapper = mapper;
    }

    public boolean usernameExists(String username) {
        int result = mapper.usernameExists(username);
        System.out.println("쿼리 보낸 count 수 : "+result);
        boolean re = result == 0;
        return re;
    }
    @Transactional
    public boolean checkEmail(String id,String key) {

        boolean result = mapper.checkEmail(id, key);
        System.out.println(result);
        return result;
    }

    public boolean checkCode(String id, String pwdCode) {
        boolean result = mapper.checkCode(id,pwdCode);
        System.out.println("checkCode() : ");
        return result;
    }
}
