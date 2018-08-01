package com.cedro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = { JpaRepositoriesAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EntityScan
public class CedroTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(CedroTechApplication.class, args);
	}
}
