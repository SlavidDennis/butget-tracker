package com.easyutils.homebudgettracker.controller;

import com.easyutils.homebudgettracker.domain.UserProfile;
import com.easyutils.homebudgettracker.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController extends DomainController {

    @Autowired
    private ProfileService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createAccount(@RequestBody UserProfile userProfile) {
        return ResponseEntity.ok(createdUuidResponse("createdProfile", service.createProfile(userProfile)));
    }
}
