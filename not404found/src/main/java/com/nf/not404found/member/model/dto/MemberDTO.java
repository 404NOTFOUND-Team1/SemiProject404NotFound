package com.nf.not404found.member.model.dto;


public class MemberDTO {
    String id;
    String password;
    String name;
    String email;
    String phone_number;

    public MemberDTO() {}

    public MemberDTO(String id, String password, String name, String email, String phone_number) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
