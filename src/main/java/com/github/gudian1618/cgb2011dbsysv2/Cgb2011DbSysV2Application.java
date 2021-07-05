package com.github.gudian1618.cgb2011dbsysv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableCaching
@EnableAsync
@SpringBootApplication
public class Cgb2011DbSysV2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cgb2011DbSysV2Application.class, args);
	}

}
