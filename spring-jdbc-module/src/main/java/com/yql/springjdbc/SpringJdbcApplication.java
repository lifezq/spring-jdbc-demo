package com.yql.springjdbc;

import com.yql.springjdbc.model.Users;
import com.yql.springjdbc.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Package com.yql.springjdbc
 * @ClassName SpringJdbcApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/28
 */
@SpringBootApplication
public class SpringJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.saveAll(Arrays.asList(
                    new Users(1L, "zhangsan", "beijing", 23, "男", 5554.22, LocalDateTime.now()),
                    new Users(2L, "lisi", "shanghai", 28, "男", 6886.23, LocalDateTime.now())
            ));
        };
    }
}
