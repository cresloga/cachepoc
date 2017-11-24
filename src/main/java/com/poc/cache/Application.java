package com.poc.cache;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;





@SpringBootApplication
@EnableCaching
public class Application  {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

  	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        logger.info("Starting Application");
    }

}