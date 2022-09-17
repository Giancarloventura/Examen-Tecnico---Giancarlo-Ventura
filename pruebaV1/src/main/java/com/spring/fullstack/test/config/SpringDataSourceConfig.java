package com.spring.fullstack.test.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "springserviceEntityManager", transactionManagerRef = "springserviceTransactionManager", basePackages = "com.spring.fullstack.test.dao")
public class SpringDataSourceConfig {
	@Primary
	@Bean(name = "springserviceEntityManager")
	public LocalContainerEntityManagerFactoryBean getServersEntityManager() {
		log.debug("LocalContainerEntityManagerFactoryBean - start");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.spring.fullstack.test.entity");
		factory.setDataSource(springserviceDataSource());
		return factory;
	}

	@Bean
	@Primary
	@ConfigurationProperties("springservice.datasource")
	public DataSource springserviceDataSource() {
		return springserviceDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	@Primary
	@ConfigurationProperties("springservice.datasource")
	public DataSourceProperties springserviceDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean
	public PlatformTransactionManager springserviceTransactionManager() {
		log.debug("springserviceTransactionManager - start");
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(getServersEntityManager().getObject());
		return transactionManager;
	}
}
