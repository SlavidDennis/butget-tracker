package com.easyutils.homebudgettracker.eao;

import com.easyutils.homebudgettracker.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, Long> {
}
