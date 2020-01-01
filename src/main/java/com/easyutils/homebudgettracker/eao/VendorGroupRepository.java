package com.easyutils.homebudgettracker.eao;

import com.easyutils.homebudgettracker.domain.VendorGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorGroupRepository extends JpaRepository<VendorGroup, Long> {

    List<VendorGroup> findAllByGroupName(String groupName);

    VendorGroup findByUuid(String groupUuid);
}
