package com.easyutils.homebudgettracker.controller;

import com.easyutils.homebudgettracker.domain.Account;
import com.easyutils.homebudgettracker.domain.dto.UserProfileDto;
import com.easyutils.homebudgettracker.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController extends DomainController {

    @Autowired
    private AccountService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(createdUuidResponse("createdAccount", service.createAccount(account)));
    }

    @GetMapping(produces = "application/json")
    @RequestMapping("/{accountUuid}/userProfiles")
    public ResponseEntity<List<UserProfileDto>> getProfilesForAccount(@PathVariable String accountUuid) {
        return ResponseEntity.ok(service.getProfilesForAccount(accountUuid));
    }
}
