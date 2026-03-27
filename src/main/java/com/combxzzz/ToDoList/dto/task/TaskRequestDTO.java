package com.combxzzz.ToDoList.dto.task;

import jakarta.validation.constraints.NotBlank;

public record TaskRequestDTO(
        @NotBlank
        String title,
        String description
) {}
