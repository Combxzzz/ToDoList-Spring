package com.combxzzz.ToDoList.mapper;

import com.combxzzz.ToDoList.dto.task.TaskResponseDTO;
import com.combxzzz.ToDoList.entity.Task;

public class TaskMapper {
    public static TaskResponseDTO toResponseDTO(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }

    public static Task toEntity(String title, String description) {
        return Task.builder()
                .title(title)
                .description(description)
                .build();
    }
}
