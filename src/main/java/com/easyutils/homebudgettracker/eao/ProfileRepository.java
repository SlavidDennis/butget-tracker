package com.easyutils.homebudgettracker.eao;

import com.easyutils.homebudgettracker.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
