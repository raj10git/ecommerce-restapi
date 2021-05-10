package com.rajat.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.convert.Jsr310Converters;


@SpringBootApplication
@EntityScan(basePackageClasses = {EcommerceRestapiApplication.class, Jsr310Converters.class})
public class EcommerceRestapiApplication{

	public static void main(String[] args) {
		SpringApplication.run(EcommerceRestapiApplication.class, args);
	}

}
