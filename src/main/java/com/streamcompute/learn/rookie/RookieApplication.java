package com.streamcompute.learn.rookie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RookieApplication {

	public static void main(String[] args) {
		SpringApplication.run(RookieApplication.class, args);


	}
}




