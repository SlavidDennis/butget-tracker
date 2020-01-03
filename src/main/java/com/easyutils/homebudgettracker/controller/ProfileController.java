package com.easyutils.homebudgettracker.controller;

import com.easyutils.homebudgettracker.domain.UserProfile;
import com.easyutils.homebudgettracker.domain.dto.VendorGroupDto;
import com.easyutils.homebudgettracker.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController extends DomainController {

    @Autowired
    private UserProfileService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createAccount(@RequestBody UserProfile userProfile) {
        return ResponseEntity.ok(createdUuidResponse("createdProfile", service.createProfile(userProfile)));
    }

    @GetMapping(produces = "application/json")
    @RequestMapping("/{profileUuid}/vendorGroups")
    public ResponseEntity<List<VendorGroupDto>> getVendorGroupsForProfile(@PathVariable String profileUuid) {
        return ResponseEntity.ok(service.getVendorGroupsForProfile(profileUuid));
    }
}
