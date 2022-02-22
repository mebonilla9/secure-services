package dev.manuel.user;

import dev.manuel.clients.lasting.FeignErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "dev.manuel.clients")
public class UserApplication {
  public static void main(String... args) {
    SpringApplication.run(UserApplication.class, args);
  }

  @Bean
  public FeignErrorDecoder errorDecoder(){
    return new FeignErrorDecoder();
  }
}
