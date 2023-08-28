package com.task.task.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.task.task.entities.Task;
import com.task.task.repositories.TaskRepository;


@Configuration
public class Instantitation implements CommandLineRunner {
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Task task1 = new Task(null, "Jogar lixo fora", "Jogar o lixo para fora");
		Task task2 = new Task(null, "Jogar lixo foraaaa", "Jogar o lixo para foraaaa");
		
		taskRepository.saveAll(Arrays.asList(task1, task2));
		
		
	}

}
