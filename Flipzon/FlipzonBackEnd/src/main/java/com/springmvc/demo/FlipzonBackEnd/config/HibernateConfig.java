package com.springmvc.demo.FlipzonBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Configures component scanning directives for use with @Configuration classes. Provides support parallel with Spring XML's <context:component-scan> element.

//Enables Spring's annotation-driven transaction management capability, similar to the support found in Spring's <tx:*> XML namespace. To be used on @Configuration classes to configure traditional, imperative transaction management or reactive transaction management.

@Configuration
@ComponentScan(basePackages = {"com.springmvc.demo.FlipzonBackEnd.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	//Package to keep all the application related configuration file inside the config package.
	
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/online-store";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	
	/*
	 * Three beans will be created i.e.
 -- `DataSource` (providing the connection information of the database)
 -- `SessionFactory` (configures application to use Hibernate and create a session
object)
 -- `HibernateTransactionManager` (to manage the hibernate transactions)
	 */
	
	//In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your application. Beans, and the dependencies among them, are reflected in the configuration metadata used by a container.
	
	//making dataSource bean available
	@Bean("dataSource")
	public DataSource getDataSource() {
		//provide database connection details
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	
	//making sessionfactory bean available
	//SessionFactory is an interface. SessionFactory can be created by providing Configuration object, which will contain all DB related property details pulled from either hibernate.cfg.xml file or hibernate.properties file. SessionFactory is a factory for Session objects.

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.springmvc.demo.FlipzonBackEnd.dto");
		return builder.buildSessionFactory();
	}

	//returns all the hibernate properties
private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		//properties.put("hibernate.hbm2ddl.auto", "create");
		
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
