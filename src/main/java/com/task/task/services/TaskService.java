package com.task.task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.task.DTO.TaskDTO;
import com.task.task.entities.Task;
import com.task.task.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
	
	public Task findById(Long id) {
		return taskRepository.findById(id).get();
	}
	
	public void insert(Task task) {
		taskRepository.save(task);
	}
	
	public Task fromDTO(TaskDTO taskDTO) {
		Task task = new Task(taskDTO.id(), taskDTO.title(), taskDTO.desc());
		return task;
	}
	
}
