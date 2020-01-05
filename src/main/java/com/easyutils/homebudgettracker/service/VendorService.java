package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.Vendor;
import com.easyutils.homebudgettracker.domain.VendorGroup;
import com.easyutils.homebudgettracker.domain.dto.VendorDto;
import com.easyutils.homebudgettracker.domain.dto.VendorGroupDto;

import java.util.List;

public interface VendorService {

    String createVendorGroup(VendorGroup vendorGroup);

    String createVendor(Vendor vendor, String groupUuid);

    List<VendorGroupDto> getVendorGroupsForProfile(String profileUuid);

    List<VendorDto> getVendorsForVendorGroup(String groupUuid);
}
