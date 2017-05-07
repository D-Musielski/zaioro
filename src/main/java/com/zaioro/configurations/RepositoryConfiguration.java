package com.zaioro.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Val on 2017-04-09.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan (basePackages = {"com.zaioro.models"})
@EnableJpaRepositories (basePackages = {"com.zaioro.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
