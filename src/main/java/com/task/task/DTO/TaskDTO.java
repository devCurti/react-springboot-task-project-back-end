package com.task.task.DTO;

import com.task.task.entities.Task;

public record TaskDTO(Long id, String title, String desc, String finished) {
	public TaskDTO(Task task) {
		this(task.getId(), task.getTitle(), task.getDesc(), task.isFinished());
	}

	
}
