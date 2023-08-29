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
		Task task = new Task(taskDTO.id(), taskDTO.title(), taskDTO.desc(), taskDTO.finished());
		return task;
	}
	
	public void delete(Long id) {
		taskRepository.deleteById(id);
	}
	
	public void update(Long id) {
		Task task = findById(id);
		if(task.isFinished() != "true") {
			task.setFinished("true");
		}else {
			task.setFinished("false");
		}
		taskRepository.save(task);
	}
	
}
