package com.easyutils.homebudgettracker.controller;

import com.easyutils.homebudgettracker.domain.Vendor;
import com.easyutils.homebudgettracker.domain.VendorGroup;
import com.easyutils.homebudgettracker.domain.dto.VendorDto;
import com.easyutils.homebudgettracker.service.VendorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendorGroup")
public class VendorController extends DomainController {

    @Autowired
    private VendorServiceImpl service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createVendorGroup(@RequestBody VendorGroup vendorGroup) {
        return ResponseEntity.ok(createdUuidResponse("createdVendorGroup",
                service.createVendorGroup(vendorGroup)));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @RequestMapping("/{groupUuid}/vendor")
    public ResponseEntity<Object> createVendorInGroup(@RequestBody Vendor vendor, @PathVariable String groupUuid) {
        return ResponseEntity.ok(createdUuidResponse("createdVendor",
                service.createVendor(vendor, groupUuid)));
    }

    @GetMapping(produces = "application/json")
    @RequestMapping("/{groupUuid}/vendors")
    public ResponseEntity<List<VendorDto>> getVendorsForVendorGroup(@PathVariable String groupUuid) {
        return ResponseEntity.ok(service.getVendorsForVendorGroup(groupUuid));
    }
}
