package com.sahu.chinmaya.employeeserver.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan("com.sahu.chinmaya.employeeserver")
@Import(SwaggerConfig.class)
public class Config {

	@Bean
	public DataSource dataSource() {
	    return new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.HSQL)
	    		.addScripts("classpath:sql/tables.sql","classpath:sql/insert.sql")
	    		//.addScript("classpath:sql/tables.sql")
	    		//.addScript("classpath:sql/insert.sql")
	    		.build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPersistenceUnitName("emp-persist");
		em.setDataSource(dataSource());
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaDialect(new HibernateJpaDialect());
		em.setPackagesToScan("com.sahu.chinmaya.employeeserver");
		em.setJpaPropertyMap(additionalProperties());

		return em;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf)
	{
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(emf);
		return jpaTransactionManager;
	}

	private Map<String, ?> additionalProperties() {
        HashMap<String, String> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.format_sql","false");
		return properties;
	}

}
