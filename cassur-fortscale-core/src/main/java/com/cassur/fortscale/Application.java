package com.cassur.fortscale;

import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mangofactory.swagger.plugin.EnableSwagger;

/*
 * This is the main Spring Boot application class. It configures Spring Boot, JPA, Swagger
 */

@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@ComponentScan(basePackages = "com.cassur.fortscale")
@EnableJpaRepositories("com.cassur.fortscale.dao.jpa") // To segregate MongoDB and JPA repositories. Otherwise not needed.
@EnableSwagger // auto generation of API docs
@SpringBootApplication
public class Application {

    private static final Class<Application> applicationClass = Application.class;
    private static final Logger log = LoggerFactory.getLogger(applicationClass);

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
		SpringApplication.run(applicationClass, args);
	}
}
