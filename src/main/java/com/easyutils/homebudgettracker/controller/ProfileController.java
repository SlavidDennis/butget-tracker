package com.easyutils.homebudgettracker.controller;

import com.easyutils.homebudgettracker.domain.Profile;
import com.easyutils.homebudgettracker.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/profile")
public class ProfileController extends DomainController {

    @Autowired
    private ProfileService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createAccount(@RequestBody Profile profile) {
        profile.setUuid(UUID.randomUUID().toString());
        service.createProfile(profile);
        return ResponseEntity.ok(createdUuidResponse("createdProfile", profile.getUuid()));
    }
}
