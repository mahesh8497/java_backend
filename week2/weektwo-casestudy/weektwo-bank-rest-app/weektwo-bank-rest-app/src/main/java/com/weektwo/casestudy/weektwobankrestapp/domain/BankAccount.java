package com.weektwo.casestudy.weektwobankrestapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long acNum;
    private Long acNum2; // test case
    private String acHldNm;
    private Double balance;
    private Boolean status;
    private Date acCrDt;

    public Long getAcNum() {
        return acNum;
    }

    public void setAcNum(Long acNum) {
        this.acNum = acNum;
    }

    public String getAcHldNm() {
        return acHldNm;
    }

    public void setAcHldNm(String acHldNm) {
        this.acHldNm = acHldNm;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getAcCrDt() {
        return acCrDt;
    }

    public void setAcCrDt(Date acCrDt) {
        this.acCrDt = acCrDt;
    }



    public Long getAcNum2() {
        return acNum2;
    }

    public void setAcNum2(Long acNum2) {
        this.acNum2 = acNum2;
    }
}
