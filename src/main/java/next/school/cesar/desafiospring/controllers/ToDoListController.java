package next.school.cesar.desafiospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import next.school.cesar.desafiospring.entities.ToDoListEntity;
import next.school.cesar.desafiospring.services.ToDoListService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/todolists")
public class ToDoListController {
	@Autowired
	private ToDoListService service;
	
	 @GetMapping
	  public List<ToDoListEntity> getAll() {
	    return service.findAll();
	  }
	 
	 @GetMapping("/{id}")
	  public ToDoListEntity getById(@PathVariable Long id) {
	    return service.findById(id);
	  }
	 
	 @PostMapping
	 public ToDoListEntity post(@RequestBody ToDoListEntity entity) {
	 	return service.save(entity);
	 }
	 
	 @PutMapping
	 public ToDoListEntity put(@RequestBody ToDoListEntity entity) {
		 return service.update(entity);
	 }
	 
	 @DeleteMapping("/{id}")
	 public String deleteById(@PathVariable Long id) {
		 return service.deleteById(id);
	 }
	 
	 
}
