package com.combxzzz.ToDoList.service;

import com.combxzzz.ToDoList.dto.task.TaskRequestDTO;
import com.combxzzz.ToDoList.dto.task.TaskResponseDTO;
import com.combxzzz.ToDoList.entity.Task;
import com.combxzzz.ToDoList.entity.enums.TaskStatus;
import com.combxzzz.ToDoList.mapper.TaskMapper;
import com.combxzzz.ToDoList.repository.TaskRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDTO create(TaskRequestDTO dto) {
        Task task = TaskMapper.toEntity(dto);
        Task saved = taskRepository.save(task);
        return TaskMapper.toDTO(saved);
    }

    public List<TaskResponseDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toDTO)
                .toList();
    }

    public TaskResponseDTO findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not Found"));

        return TaskMapper.toDTO(task);
    }

    public TaskResponseDTO update(Long id, TaskRequestDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not Found"));

        if (dto.title() != null) {
            if (dto.title().isBlank()) throw new RuntimeException("Title cannot be empty");
            task.setTitle(dto.title());
        }

        if (dto.description() != null) {
            task.setDescription(dto.description());
        }

        Task updated = taskRepository.save(task);
        return TaskMapper.toDTO(updated);
    }

    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not Found");
        }
        taskRepository.deleteById(id);
    }

    public TaskResponseDTO switchStatus(Long id, TaskStatus newStatus) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not Found"));

        task.setStatus(newStatus);

        Task saved = taskRepository.save(task);
        return TaskMapper.toDTO(saved);
    }
}
