package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
	    basePackages = "com.example.demo.repository.department", 
	    entityManagerFactoryRef = "departmentEntityManager", 
	    transactionManagerRef = "departmentTransactionManager"
	)
public class DepartmentDataSourceConfig {
	
	@Autowired
    private Environment env;
	
	
	@Bean
	@ConfigurationProperties(prefix="department.datasource")
	public DataSource departmentDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	
	@Bean
    public LocalContainerEntityManagerFactoryBean departmentEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(departmentDataSource());
        em.setPackagesToScan(new String[] { "com.example.demo.dao.department" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
        em.setJpaPropertyMap(properties);

        return em;
    }

	
	@Bean
    public PlatformTransactionManager departmentTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(departmentEntityManager().getObject());
        return transactionManager;
    }

}
