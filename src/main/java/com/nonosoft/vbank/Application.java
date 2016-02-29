package com.nonosoft.vbank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.getProperty;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    logger.info("<< Profile: {} >>", getProperty("spring.profiles.active"));
    SpringApplication.run(Application.class, args);
  }

  private static final Logger logger = LoggerFactory.getLogger(Application.class);
}
