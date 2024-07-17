package next.school.cesar.desafiospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import next.school.cesar.desafiospring.entities.TaskEntity;
import next.school.cesar.desafiospring.services.TaskService;


@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService service;
	
	 @GetMapping
	  public List<TaskEntity> getAll() {
	    return service.findAll();
	  }
	 
	 @GetMapping("/{id}")
	  public TaskEntity getById(@PathVariable Long id) {
	    return service.findById(id);
	  }
	 
	 @PostMapping
	 public TaskEntity post(@RequestBody TaskEntity entity) {
	 	return service.save(entity);
	 }
	 
	 @PutMapping
	 public TaskEntity put(@RequestBody TaskEntity entity) {
		 return service.update(entity);
	 }
	 
	 @DeleteMapping("/{id}")
	 public String deleteToDoListById(@PathVariable Long id) {
		 return service.deleteById(id);
	 }
	 
	 
}
