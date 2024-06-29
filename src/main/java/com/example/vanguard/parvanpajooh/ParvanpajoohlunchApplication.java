package com.example.vanguard.parvanpajooh;

import com.parvanpajooh.aggregate.DomainModuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({InfrastructureModuleConfig.class, DomainModuleConfig.class})
public class ParvanpajoohlunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParvanpajoohlunchApplication.class, args);
    }

}
