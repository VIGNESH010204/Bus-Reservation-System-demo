

package com.busreservation.bus_reservation_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.busreservation")
@EnableJpaRepositories(basePackages = "com.busreservation.repository")
@EntityScan(basePackages = "com.busreservation.model")
public class App{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
