package com.easyutils.homebudgettracker.service;

import com.easyutils.homebudgettracker.domain.UserProfile;
import com.easyutils.homebudgettracker.domain.dto.UserProfileDto;
import com.easyutils.homebudgettracker.domain.dto.VendorGroupDto;
import com.easyutils.homebudgettracker.eao.UserProfileRepository;
import com.easyutils.homebudgettracker.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    @Autowired
    private VendorServiceImpl vendorService;

    @Autowired
    private ModelMapper modelMapper;

    public String createProfile(UserProfile userProfile) {
        userProfile.setUuid(UUID.randomUUID().toString());
        userProfile.setPrimary(CollectionUtils.isEmpty(getProfilesForAccount(userProfile.getAccountUuid())));
        repository.save(userProfile);
        return userProfile.getUuid();
    }

    public List<UserProfileDto> getProfilesForAccount(String accountUuid) {
        return repository.findByAccountUuid(accountUuid).stream()
                .map(up -> modelMapper.map(up, UserProfileDto.class))
                .collect(toList());
    }

    public List<VendorGroupDto> getVendorGroupsForProfile(String profileUuid) {
        return vendorService.getVendorGroupsForProfile(profileUuid);
    }
}
