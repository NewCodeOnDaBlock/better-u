package com.raden.diet_gram.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.raden.diet_gram.models.Task;
import com.raden.diet_gram.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	public TaskRepository taskRepository;
	
	public List<Task> allTasks() { 
		return taskRepository.findAll();
	}

	
	public Task createTask(Task task, BindingResult result) { 
		
		if(result.hasErrors()) {
           
			return null;
			
		} else {
			
			return taskRepository.save(task);
		}
	}
	
	public Task findTaskById(Long id) { 
		Optional<Task> taskByID = taskRepository.findById(id);
		if (taskByID.isPresent()) {
			return taskByID.get();
		} else {
			return null;
		}
	}

	
	public void updateFinish(Long id, boolean finish) { 
		taskRepository.updateFinish(id, finish);
	}
	
	

	public Task updateTask(Task task, BindingResult result) { 
		
		if(result.hasErrors()) {
	           
			return null;
			
		} else {
			
			return taskRepository.save(task);
			
		}
	}
	
	
	

	public void deleteTask(Long id) { 
		taskRepository.deleteById(id);
	}

}
