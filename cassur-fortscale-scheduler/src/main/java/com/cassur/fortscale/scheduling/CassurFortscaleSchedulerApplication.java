package com.cassur.fortscale.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cassur.fortscale.scheduling.model.Uba;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class CassurFortscaleSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassurFortscaleSchedulerApplication.class, args);
	}
	
}
