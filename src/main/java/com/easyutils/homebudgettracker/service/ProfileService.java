package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.UserProfile;
import com.easyutils.homebudgettracker.eao.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    public String createProfile(UserProfile userProfile) {
        userProfile.setUuid(UUID.randomUUID().toString());
        if (CollectionUtils.isEmpty(getProfilesForAccount(userProfile.getAccountUuid()))) {
            userProfile.setPrimary(true);
        }
        repository.save(userProfile);
        return userProfile.getUuid();
    }

    private List<UserProfile> getProfilesForAccount(String accountUuid) {
        return repository.findByAccountUuid(accountUuid);
    }
}
