package com.nf.not404found.mypage;

import com.nf.not404found.common.functions.UserInformation;
import com.nf.not404found.mypage.model.dto.AddrDTO;
import com.nf.not404found.mypage.model.dto.MyPageDTO;
import com.nf.not404found.mypage.model.service.MyPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
    private final UserInformation user;
    private final MyPageService service;
    public MyPageController(UserInformation user,MyPageService service){
        this.user = user;
        this.service = service;
    }

    @GetMapping("/home")
    public ModelAndView myPage(ModelAndView mv){
        MyPageDTO myPage = new MyPageDTO(user.getId(),user.getEmail(), user.getName(), user.getPhone(),"010-1111-2222","브론즈");
        //AddrDTO addr = new AddrDTO(user.getAddr(), user.getAddrzipCode(), user.getAddrName(),user.getAddrDetail());
        //service.selectUserAddr(user.getId());
        List<AddrDTO> list = service.selectUserAddr(user.getId());
//
//        for(int i=0; i>=list.size(); i++){
//            mv.addObject()
//        }
        mv.addObject("id",myPage);
        mv.addObject("addr",list);
        mv.getModel();
        mv.setViewName("mypage/home");
        return mv;
    }
    @PostMapping("changePhone")
    @ResponseBody
    public boolean changePhone(@RequestBody String phone){
        return service.changePhone(phone);
    }
    @PostMapping("changeEmail")
    @ResponseBody
    public boolean changeEmail(@RequestBody String email){
        return service.changeEmail(email);
    }
    @PostMapping("changePwd")
    @ResponseBody
    public boolean changePwd(@RequestBody String pwd){
        return service.changePwd(pwd);
    }
    @PostMapping("insertAddress")
    @ResponseBody
    public boolean insertAddr(@RequestBody AddrDTO addr){
        System.out.println("여기까진 옴");
        System.out.println(addr.getName());
        System.out.println(addr.getZonecode());
        System.out.println(addr.getAddress());
        System.out.println(addr.getAddrDetail());
        return service.insertAddr(addr);
    }
    @PostMapping("deleteAddr")
    @ResponseBody
    public boolean deleteAddr(@RequestBody String name){

        return service.deleteAddr(name);
    }

}