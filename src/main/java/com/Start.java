package com;

import com.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

        import java.lang.annotation.RetentionPolicy;

@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class,args);
    }
}
