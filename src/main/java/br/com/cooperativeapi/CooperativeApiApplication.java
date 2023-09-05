package br.com.cooperativeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.cooperativeapi")
@EntityScan("br.com.cooperativeapi.entity")
@EnableJpaRepositories("br.com.cooperativeapi.repository")
@EnableAutoConfiguration
public class CooperativeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CooperativeApiApplication.class, args);
    }

}
