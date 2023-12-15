package com.nf.not404found.member.model.service;

import com.nf.not404found.common.random.RandomString;
import com.nf.not404found.member.model.dao.EmailMapper;
import com.nf.not404found.member.model.dto.PwdFindDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.nf.not404found.common.random.RandomString.createRandomString;

@Service
public class EmailService {
    private final EmailMapper mapper;
    public EmailService(EmailMapper mapper){
        this.mapper = mapper;
    }


    public int insertRandomEmailCode(String userId, String random) {
        //받아오는 userId 와 random 값 콘솔창에 출력 가능하게 해보자


            PwdFindDTO pwdFind = new PwdFindDTO();
            pwdFind.setId(userId);
            pwdFind.setPwd_key(random);
            int randomStr = mapper.insertRandomEmailCode(pwdFind);

            if(randomStr > 0 ){
                System.out.println("DB추가 : 성공" + randomStr);
            }else{
                System.out.println("DB추가 : 실패");
            }

            return randomStr;
        }


    }

//    @Transactional  //커밋 용
//    public boolean checkEmail2(String id,String key) {   //아이디, 랜덤 키 갖고
//        boolean result = mapper.checkEmail2(id, key);    //매퍼로 ㄱㄱ
//        System.out.println(result);                     //잘 됐는지 출력 용
//        return result;
//    }
//
//    public int checkCode2(String id, String pwdCode) {
//        int result = mapper.checkCode2(id,pwdCode);
//        System.out.println("사용자가 입력한 pwdCode와 id가 일치하는 테이블은 몇개?? : "+result);
//        return result;
//    }
