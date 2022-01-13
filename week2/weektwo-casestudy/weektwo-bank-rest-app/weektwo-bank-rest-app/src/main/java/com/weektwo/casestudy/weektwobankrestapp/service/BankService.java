package com.weektwo.casestudy.weektwobankrestapp.service;

import com.weektwo.casestudy.weektwobankrestapp.domain.BankAccount;
import com.weektwo.casestudy.weektwobankrestapp.exception.InvalidAmountException;

import java.util.List;

public interface BankService  {
    void createNewAccount(BankAccount ba);

    int updateAccountDetails(BankAccount ba);

    boolean activateAccount(Long acNum);

    boolean deActivateAccount(Long acNum);

    double withdraw(Long acNum, double amt) throws InvalidAmountException;

    double deposit(Long acNum, double amt) throws InvalidAmountException;

    int transferMoney(Long srcAc, Long dstAc, double amt);

    BankAccount findAccountByAcNum(Long acNum);

    List<BankAccount> findAllBankAccounts();

    List<BankAccount> namesStartsWith(String prefix);
}
