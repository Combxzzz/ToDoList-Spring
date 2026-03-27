package com.combxzzz.ToDoList.mapper;

import com.combxzzz.ToDoList.dto.task.TaskRequestDTO;
import com.combxzzz.ToDoList.dto.task.TaskResponseDTO;
import com.combxzzz.ToDoList.entity.Task;

public class TaskMapper {
    public static TaskResponseDTO toDTO(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }

    public static Task toEntity(TaskRequestDTO dto) {
        return Task.builder()
                .title(dto.title())
                .description(dto.description())
                .build();
    }
}
