package com.example.spring.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan
@EnableJpaRepositories
@EnableTransactionManagement
class DbConfiguration {
}
