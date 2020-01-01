package com.easyutils.homebudgettracker.eao;

import com.easyutils.homebudgettracker.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    List<Vendor> findAllByVendorName(String vendorName);
}
