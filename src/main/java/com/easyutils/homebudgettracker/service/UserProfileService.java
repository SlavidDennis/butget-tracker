package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.UserProfile;
import com.easyutils.homebudgettracker.domain.dto.UserProfileDto;
import com.easyutils.homebudgettracker.domain.dto.VendorGroupDto;

import java.util.List;

public interface UserProfileService {

    String createProfile(UserProfile userProfile);

    List<UserProfileDto> getProfilesForAccount(String accountUuid);

    List<VendorGroupDto> getVendorGroupsForProfile(String profileUuid);
}
