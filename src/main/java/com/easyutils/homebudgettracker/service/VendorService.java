package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.Vendor;
import com.easyutils.homebudgettracker.domain.VendorGroup;
import com.easyutils.homebudgettracker.eao.VendorGroupRepository;
import com.easyutils.homebudgettracker.eao.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VendorService {

    @Autowired
    private VendorGroupRepository groupRepository;

    @Autowired
    private VendorRepository vendorRepository;

    public String createVendorGroup(VendorGroup vendorGroup) {
        vendorGroup.setUuid(UUID.randomUUID().toString());
        groupRepository.save(vendorGroup);
        return vendorGroup.getUuid();
    }

    public String createVendor(Vendor vendor, String groupUuid) {
        vendor.setUuid(UUID.randomUUID().toString());
        vendor.setVendorGroupUuid(groupUuid);
        vendorRepository.save(vendor);
        return vendor.getUuid();
    }
}
