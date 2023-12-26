package com.nf.not404found.common.functions;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserInformation {
    private final UserInformationMapper mapper;
    //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //인증 후 최종 인증 결과를 Authentication 객체에 담고
    public UserInformation(UserInformationMapper mapper){
        this.mapper = mapper;
    }

    /**
     * 로그인한 유저의 ID를 받아오는 메소드
     * @return 로그인한 유저 아이디
     */
    public String getId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {  //auth 객체가 null 또는 권한 상관 없이 로그인 인증을 받지 않은 경우에는
            return null;                                //null 리턴
        }
        Object principal = auth.getPrincipal(); //현재 로그인한 사용자의 대한 정보를 저장한다.
        if (principal instanceof UserDetails) {     //Object타입의 principal의 타입과 일치한다면?
            return ((UserDetails) principal).getUsername(); //principal을 UserDetail 타입으로 형 변환 후 getUserName()메소드 호출 후 반환
        }
        return null;    //타입이 일치하지 않으면 null 반환
    }
    /**
     * 로그인한 유저의 Email을 받아오는 메소드
     * @return 로그인한 유저 Email
     */
    public String getEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
             return mapper.SearchUserEmail(((UserDetails) principal).getUsername());
        }
        return null;

    }
    /**
     * 로그인한 유저의 이름 받아오는 메소드
     * @return 로그인한 유저 이름
     */
    public String getName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserName(((UserDetails) principal).getUsername());
        }
        return null;
    }
    public String getMileage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserMileage(((UserDetails) principal).getUsername());
        }
        return null;
    }
    /**
     * 로그인한 유저의 핸드폰 번호를 받아오는 메소드
     * @return 로그인한 유저 핸드폰 번호
     */
    public String  getPhone() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserPhone(((UserDetails) principal).getUsername());
        }
        return null;
    }
    public List<String> getCoupon() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserCoupon(((UserDetails) principal).getUsername());
        }
        return null;
    }
    public List<String> getAddr() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserAddr(((UserDetails) principal).getUsername());
        }
        return null;
    }
    public String  getAddrzipCode() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserAddrZipCode(((UserDetails) principal).getUsername());
        }
        return null;
    }
    public List<String>  getAddrDetail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserAddrDetail(((UserDetails) principal).getUsername());
        }
        return null;
    }
    public String  getAddrName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserAddrName(((UserDetails) principal).getUsername());
        }
        return null;
    }
    private int  getAddrCount() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return 0;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserAddrCount(((UserDetails) principal).getUsername());
        }
        return 0;
    }

    public String  getStatus() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails) {
            return mapper.SearchUserStatus(((UserDetails) principal).getUsername());
        }
        return null;
    }

}
