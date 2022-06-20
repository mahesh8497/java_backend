package com.weektwo.casestudy.weektwobankrestapp.service;

import com.weektwo.casestudy.weektwobankrestapp.domain.BankAccount;
import com.weektwo.casestudy.weektwobankrestapp.exception.AccountNotFoundException;
import com.weektwo.casestudy.weektwobankrestapp.exception.InActiveAccountException;
import com.weektwo.casestudy.weektwobankrestapp.exception.InvalidAmountException;
import com.weektwo.casestudy.weektwobankrestapp.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = InvalidAmountException.class
)
@Service
public class BankServiceImpl implements BankService{
    private final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    private BankRepository repository;

    @Override
    public void createNewAccount(BankAccount ba) {
        repository.save(ba);
    }

    @Override
    public int updateAccountDetails(BankAccount ba) {
        BankAccount oldData=repository.findById(ba.getAcNum()).orElse(null);
        oldData.setAcHldNm(oldData.getAcHldNm());
        oldData.setAcCrDt(oldData.getAcCrDt());
        oldData.setStatus(oldData.getStatus());
        oldData.setBalance(oldData.getBalance());
        repository.save(oldData);
        return 0;
    }

    @Override
    public boolean activateAccount(Long acNum)
    {
        Optional<BankAccount>op=repository.findById(acNum);
        BankAccount baOld=op.orElseThrow();
        boolean existingStatus=baOld.getStatus();
        Boolean newStatus=Boolean.parseBoolean("true");
        BankAccount baNew=new BankAccount();
        baNew.setBalance(baOld.getBalance());
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(newStatus);
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());
        repository.save(baNew);
        return baNew.getStatus();
    }

    @Override
    public boolean deActivateAccount(Long acNum)
    {
        Optional<BankAccount>op=repository.findById(acNum);
        BankAccount baOld=op.orElseThrow();
        boolean existingStatus=baOld.getStatus();
        Boolean newStatus=Boolean.parseBoolean("false");
        BankAccount baNew=new BankAccount();
        baNew.setBalance(baOld.getBalance());
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(newStatus);
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());
        repository.save(baNew);
        return baNew.getStatus();

    }

    @Override
    public double withdraw(Long acNum, double amt) throws InvalidAmountException {
        logger.info("Withdrawing Money from "+acNum +" with Amount  "+amt);
        logger.warn("Make sure amount possittive");
        repository.withdraw(amt, acNum);
        return amt;
    }


    @Override
    public double deposit(Long acNum, double amt) throws InvalidAmountException {
        // just explanation I am using this strategy
        // it can be done in more efficient way

        if (amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive " + amt);

        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();

        Boolean existingStatus = baOld.getStatus();

        if (existingStatus != true) {
            return 0;
        }
        else {
            double newBalance = existingBalance + amt;

            BankAccount baNew = new BankAccount();
            baNew.setBalance(newBalance);
            baNew.setAcCrDt(baOld.getAcCrDt());
            baNew.setStatus(baOld.getStatus());
            baNew.setAcHldNm(baOld.getAcHldNm());
            baNew.setAcNum(baOld.getAcNum());

            repository.save(baNew);

            return baNew.getBalance();

        }
    }

    @Override
    public int transferMoney(Long srcAc, Long dstAc, double amt) throws InvalidAmountException, InActiveAccountException, AccountNotFoundException {
        if(amt < 0) throw new InvalidAmountException("Amount should be positive : "+ amt);

        BankAccount sa = repository.findById(srcAc)
                .orElseThrow(
                        () -> new AccountNotFoundException("Source Account Not Found : "+ srcAc)
                );

        if(!Boolean.TRUE.equals(sa.getStatus())) throw new InActiveAccountException("Source Account Not Active Yet");

        BankAccount da = repository.findById(dstAc)
                .orElseThrow(
                        () -> new AccountNotFoundException("Destination Account Not "+ dstAc)
                );

        if(!Boolean.TRUE.equals(da.getStatus())) throw new InActiveAccountException(("Destination Account Not Active "));

        BankAccount uSa = new BankAccount();
        uSa.setAcNum(srcAc);
        uSa.setAcHldNm(sa.getAcHldNm());
        uSa.setAcCrDt(sa.getAcCrDt());
        uSa.setBalance(sa.getBalance() - amt);
        uSa.setStatus(sa.getStatus());

        BankAccount uDa = new BankAccount();
        uDa.setAcNum(dstAc);
        uDa.setAcHldNm(da.getAcHldNm());
        uDa.setAcCrDt(da.getAcCrDt());
        uDa.setBalance(da.getBalance() + amt);
        uDa.setStatus(da.getStatus());

        repository.save(uSa);
        repository.save(uDa);

        return 1;
    }


    @Override
    public BankAccount findAccountByAcNum(Long acNum)
    {
      //  Optional<BankAccount> op = repository.findById(acNum);

        return null;
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        return null;
    }

    @Override
    public List<BankAccount> namesStartsWith(String prefix) throws InvalidAmountException {
        if (prefix.isBlank()&& prefix.isEmpty()&& prefix.length()<50)
            throw new InvalidAmountException("Name should be character"+prefix);
        return repository.findByAcHldNmStartingWith(prefix);
    }
}