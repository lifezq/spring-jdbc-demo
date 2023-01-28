package com.yql.springdatajdbc;

import com.yql.springdatajdbc.model.Users;
import com.yql.springdatajdbc.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class SpringDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.saveAll(Arrays.asList(
                    new Users("zhangsan", "beijing", 23, "男", 5554.22, LocalDateTime.now()),
                    new Users("lisi", "shanghai", 28, "男", 6886.23, LocalDateTime.now())
            ));
        };
    }
}
