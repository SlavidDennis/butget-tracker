package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.Account;
import com.easyutils.homebudgettracker.domain.dto.UserProfileDto;

import java.util.List;

public interface AccountService {

    String createAccount(Account account);

    List<UserProfileDto> getProfilesForAccount(String accountUuid);
}
