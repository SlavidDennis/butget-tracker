package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.Profile;
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

    public String createProfile(Profile profile) {
        profile.setUuid(UUID.randomUUID().toString());
        if(CollectionUtils.isEmpty(getProfilesForAccount(profile.getAccountUuid()))) {
            profile.setPrimary(true);
        }
        repository.save(profile);
        return profile.getUuid();
    }

    private List<Profile> getProfilesForAccount(String accountUuid) {
        return repository.findByAccountUuid(accountUuid);
    }
}
