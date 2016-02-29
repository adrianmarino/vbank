package com.nonosoft.vbank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import static java.lang.System.getProperty;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    logger.info("<< Environment: {} >>", getProperty("spring.profiles.active"));
    return application.sources(Application.class);
  }

  public static void main(String[] args) {
    logger.info("<< Environment: {} >>", getProperty("spring.profiles.active"));
    SpringApplication.run(Application.class, args);
  }

  private static final Logger logger = LoggerFactory.getLogger(Application.class);
}
