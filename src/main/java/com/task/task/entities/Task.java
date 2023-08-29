package com.task.task.entities;



import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@CrossOrigin
public class Task {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String finished;
	
	public Task(Long id, String title, String desc, String finished) {
		this.id = id;
		this.title = title;
		this.description = desc;
		this.finished = finished;
	}
	
	
	public Task() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}


	public String isFinished() {
		return finished;
	}


	public void setFinished(String finished) {
		this.finished = finished;
	}
	
	
}
