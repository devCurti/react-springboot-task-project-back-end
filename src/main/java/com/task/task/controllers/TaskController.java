package com.task.task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.task.DTO.TaskDTO;
import com.task.task.entities.Task;
import com.task.task.services.TaskService;


@RestController
@CrossOrigin
@RequestMapping(value = "/tasks")
public class TaskController {
	
	
	@Autowired
	TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> findAll(){
		List<Task> tasks = taskService.findAll();
		List<TaskDTO> tasksDTO = tasks.stream().map(TaskDTO::new).toList();
		return ResponseEntity.ok().body(tasksDTO);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> findById(@PathVariable Long id){
		Task task = taskService.findById(id);
		TaskDTO taskDTO = new TaskDTO(task);
		return ResponseEntity.ok().body(taskDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TaskDTO taskDTO){
		Task newTask = taskService.fromDTO(taskDTO);
		taskService.insert(newTask);
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		taskService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id){
		taskService.update(id);
		return ResponseEntity.ok().build();
	}
}
