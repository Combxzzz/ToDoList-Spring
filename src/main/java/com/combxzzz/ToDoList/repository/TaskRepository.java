package com.combxzzz.ToDoList.repository;

import com.combxzzz.ToDoList.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
