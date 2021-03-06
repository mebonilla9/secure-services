package dev.manuel.authority;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "dev.manuel.clients")
public class AuthorityApplication {
  public static void main(String... args) {
    SpringApplication.run(AuthorityApplication.class, args);
  }
}
