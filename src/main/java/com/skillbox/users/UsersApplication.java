package com.skillbox.users;

import com.skillbox.users.entity.User;
import com.skillbox.users.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    @Bean
    CommandLineRunner demoJpa(UserRepository repository) {
        return (args) -> {
            User dafaultUser = new User(
                    "name",
                    "lastName",
                    "email.lu",
                    "password",
                    new ArrayList<>()
            );
            repository.save(dafaultUser);
            System.out.println(repository.existsById(1L));
            repository.delete(dafaultUser);
            System.out.println(repository.existsById(1L));

        };
    }
}
