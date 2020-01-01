package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.VendorGroup;
import com.easyutils.homebudgettracker.eao.VendorGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VendorGroupService {

    @Autowired
    private VendorGroupRepository repository;

    public String createVendorGroup(VendorGroup vendorGroup) {
        vendorGroup.setUuid(UUID.randomUUID().toString());
        repository.save(vendorGroup);
        return vendorGroup.getUuid();
    }
}
