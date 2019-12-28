package com.easyutils.homebudgettracker.eao;

import com.easyutils.homebudgettracker.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<UserProfile, Long> {

    List<UserProfile> findByAccountUuid(String accountUuid);
}
