package com.task.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.task.entities.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

}
