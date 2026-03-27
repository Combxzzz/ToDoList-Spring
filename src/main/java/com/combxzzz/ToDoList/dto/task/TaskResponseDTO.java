package com.combxzzz.ToDoList.dto.task;

import com.combxzzz.ToDoList.entity.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        TaskStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
