package com.easyutils.homebudgettracker.controller;

import com.easyutils.homebudgettracker.domain.Account;
import com.easyutils.homebudgettracker.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController extends DomainController {

    @Autowired
    private AccountService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(createdUuidResponse("createdAccount", service.createAccount(account)));
    }
}
