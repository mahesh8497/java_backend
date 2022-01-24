package com.weektwo.casestudy.weektwobankrestapp.controller;

import com.weektwo.casestudy.weektwobankrestapp.domain.BankAccount;
import com.weektwo.casestudy.weektwobankrestapp.dto.AmountTransferDto;
import com.weektwo.casestudy.weektwobankrestapp.dto.AppResponse;
import com.weektwo.casestudy.weektwobankrestapp.exception.AccountNotFoundException;
import com.weektwo.casestudy.weektwobankrestapp.exception.InActiveAccountException;
import com.weektwo.casestudy.weektwobankrestapp.exception.InvalidAmountException;
import com.weektwo.casestudy.weektwobankrestapp.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/bank")
@RestController // = @Component
public class BankController {

    private final Logger logger = LoggerFactory.getLogger(BankController.class);
    private final String success = AppResponse.Types.SUCCESS.toString();


    @Autowired
    private BankService service;

    @PostMapping // POST -> http://localhost:8080/bank/
    public ResponseEntity<AppResponse<Integer>> createBankAccount(@RequestBody BankAccount ba) {

        logger.info("creating bank account");

        service.createNewAccount(ba);

        var response = new AppResponse<Integer>();
        response.setMsg("account created successfully");
        response.setSts(success);
        response.setBody(0);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/withdraw") // PUT -> http://localhost:8080/123456
    public ResponseEntity<AppResponse<Double>> withdrawMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.withdraw(ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("money withdrawn successfully");
            response.setSts(success);
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/deposit") // PUT -> http://localhost:8080/bank/deposit
    public ResponseEntity<AppResponse<Double>> depositMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.deposit(ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("money deposit successfully");
            response.setSts(success);
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{prefix}")
    public ResponseEntity<AppResponse<List<BankAccount>>> accountsStartWith(@PathVariable String prefix) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account list");
        response.setSts(success);
        response.setBody(service.namesStartsWith(prefix));

        return ResponseEntity.ok(response);
    }


    @PutMapping("/activate")
    public ResponseEntity<AppResponse<Boolean>> activate(@RequestBody BankAccount ba) {
        boolean stat = service.activateAccount(ba.getAcNum());
        var response = new AppResponse<Boolean>();
        response.setMsg("Account activate");
        response.setSts("Successfully Activate");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }

    @PutMapping("/deActivate")
    public ResponseEntity<AppResponse<Boolean>> Deactivate(@RequestBody BankAccount ba) {
        boolean stat = service.deActivateAccount(ba.getAcNum());
        var response = new AppResponse<Boolean>();
        response.setMsg("Account Deactivate");
        response.setSts("Success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }

    @GetMapping("/{acNum}")
    public ResponseEntity<AppResponse<List<BankAccount>>> findAccountByAcNum(@PathVariable Long acNum) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("Account List");
        response.setSts("Success");
        response.setBody((List<BankAccount>) service.findAccountByAcNum(acNum));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find")
    public ResponseEntity<AppResponse<List<BankAccount>>> findAllBankAccount() {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("Account List");
        response.setSts("Success");
        response.setBody(service.findAllBankAccounts());
        return ResponseEntity.ok(response);


    }
    @GetMapping
    public ResponseEntity<AppResponse<List<BankAccount>>> allAccounts() {

        var response = new AppResponse<List<BankAccount>>();
        response.setSts(success);
        response.setMsg("list of all accounts");
        response.setBody(service.findAllBankAccounts());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/transfer")
    public ResponseEntity<AppResponse<Integer>> transferMoney(@RequestBody AmountTransferDto dto) {

        try {
            int sts = service.transferMoney(dto.getSrcAc(), dto.getDstAc(), dto.getAmt());
            var response = new AppResponse<Integer>();
            response.setSts("success");
            response.setMsg("money transfer successful");
            response.setBody(sts);

            return ResponseEntity.ok(response);
        }catch (InvalidAmountException | AccountNotFoundException | InActiveAccountException ex) {
            var response = new AppResponse<Integer>();
            response.setSts("fail");
            response.setMsg(ex.getMessage());
            response.setBody(0);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}





