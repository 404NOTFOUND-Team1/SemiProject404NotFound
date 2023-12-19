package com.nf.not404found.kakaopay.model.dto;


import lombok.Builder;


public class Payment {

    private String paymentClassName;
    private String payMathod;
    private String payCode;

    public Payment() {
    }

    @Builder
    public Payment(String paymentClassName, String payMathod, String payCode) {
        this.paymentClassName = paymentClassName;
        this.payMathod = payMathod;
        this.payCode = payCode;
    }

    public String getPaymentClassName() {
        return paymentClassName;
    }

    public void setPaymentClassName(String paymentClassName) {
        this.paymentClassName = paymentClassName;
    }

    public String getPayMathod() {
        return payMathod;
    }

    public void setPayMathod(String payMathod) {
        this.payMathod = payMathod;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }
}
