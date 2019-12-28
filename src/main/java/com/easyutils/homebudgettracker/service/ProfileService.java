package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.Profile;
import com.easyutils.homebudgettracker.eao.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    public void createProfile(Profile profile) {
        if(CollectionUtils.isEmpty(getProfilesForAccount(profile.getAccountUuid()))) {
            profile.setPrimary(true);
        }
        repository.save(profile);
    }

    private List<Profile> getProfilesForAccount(String accountUuid) {
        return repository.findByAccountUuid(accountUuid);
    }
}
