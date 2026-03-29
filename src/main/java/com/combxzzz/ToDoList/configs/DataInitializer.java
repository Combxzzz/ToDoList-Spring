package com.combxzzz.ToDoList.configs;

import com.combxzzz.ToDoList.entity.Task;
import com.combxzzz.ToDoList.entity.enums.TaskStatus;
import com.combxzzz.ToDoList.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDataBase(TaskRepository repository) {
        return args -> {
            Task task1 = Task.builder()
                    .title("SpringBoot")
                    .description("API REST")
                    .status(TaskStatus.PENDING)
                    .build();

            Task task2 = Task.builder()
                    .title("Backend")
                    .description("DTO and Service")
                    .status(TaskStatus.IN_PROGRESS)
                    .build();

            repository.save(task1);
            repository.save(task2);
        };
    }
}
