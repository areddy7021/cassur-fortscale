package com.cassur.fortscale.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CassurFortscaleSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassurFortscaleSchedulerApplication.class, args);
	}
}
