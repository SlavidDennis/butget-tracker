package com.easyutils.homebudgettracker.eao;

import com.easyutils.homebudgettracker.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    List<Profile> findByAccountUuid(String accountUuid);
}
