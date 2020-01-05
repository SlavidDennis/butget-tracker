package com.easyutils.homebudgettracker.controller;

import com.easyutils.homebudgettracker.domain.Account;
import com.easyutils.homebudgettracker.service.AccountServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Mock
    private AccountServiceImpl service;
    @InjectMocks
    @Autowired
    private AccountController accountController;

    @Test
    void createAccount() {
        //Prepare
        String uuid = "111-222-333";
        String expectedKey = "createdAccount";
        Account account = Account.builder()
                .userName("TestAccount")
                .build();
        Mockito.when(service.createAccount(any(Account.class))).thenReturn(uuid);
        //Execute
        ResponseEntity<Object> response = accountController.createAccount(account);
        //Assert
        Assert.assertEquals(200, response.getStatusCodeValue());
        Map<String, String> responseBody = (HashMap<String, String>) response.getBody();
        Assert.assertThat(responseBody, Matchers.hasKey(expectedKey));
        Assert.assertEquals(uuid, responseBody.get(expectedKey));
    }

    @Test
    void getProfilesForAccount() {
    }
}