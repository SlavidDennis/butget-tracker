package com.easyutils.homebudgettracker.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.easyutils.homebudgettracker"})
@EntityScan("com.easyutils.homebudgettracker")
public class DbConfiguration {
}
