package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.Profile;
import com.easyutils.homebudgettracker.eao.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    public void createProfile(Profile profile) {
        repository.save(profile);
    }
}
