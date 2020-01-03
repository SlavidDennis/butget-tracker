package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.Vendor;
import com.easyutils.homebudgettracker.domain.VendorGroup;
import com.easyutils.homebudgettracker.domain.dto.VendorGroupDto;
import com.easyutils.homebudgettracker.eao.VendorGroupRepository;
import com.easyutils.homebudgettracker.eao.VendorRepository;
import com.easyutils.homebudgettracker.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class VendorService {

    @Autowired
    private VendorGroupRepository groupRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private ModelMapper modelMapper;

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

    public List<VendorGroupDto> getVendorGroupsForProfile(String profileUuid) {
        return groupRepository.findAllByUserProfileUuid(profileUuid).stream()
                .map(vg -> modelMapper.map(vg, VendorGroupDto.class))
                .collect(toList());
    }
}
