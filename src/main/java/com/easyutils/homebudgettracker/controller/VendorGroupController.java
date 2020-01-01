package com.easyutils.homebudgettracker.controller;

import com.easyutils.homebudgettracker.domain.VendorGroup;
import com.easyutils.homebudgettracker.service.VendorGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendorGroup")
public class VendorGroupController extends DomainController {

    @Autowired
    private VendorGroupService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createVendorGroup(@RequestBody VendorGroup vendorGroup) {
        return ResponseEntity.ok(createdUuidResponse("createdVendorGroup",
                service.createVendorGroup(vendorGroup)));
    }
}
