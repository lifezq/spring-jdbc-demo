package com.yql.springdatajpa;

import com.yql.springdatajpa.model.Users;
import com.yql.springdatajpa.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @Package com.yql.springdatajpa
 * @ClassName SpringDataJpaApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/28
 */
@SpringBootApplication
public class SpringDataJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.saveAll(Arrays.asList(
                    new Users("zhangsan", "beijing", 23, "男", 5554.22),
                    new Users("lisi", "shanghai", 28, "男", 6886.23)
            ));
        };
    }
}
