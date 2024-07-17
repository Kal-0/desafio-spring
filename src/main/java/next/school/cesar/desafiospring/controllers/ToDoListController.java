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
	  public List<ToDoListEntity> getAllToDoLists() {
	    return service.findAll();
	  }
	 
	 @GetMapping("/{id}")
	  public ToDoListEntity getToDoListById(@PathVariable Long id) {
	    return service.findById(id);
	  }
	 
	 @PostMapping
	 public ToDoListEntity postToDoList(@RequestBody ToDoListEntity entity) {
	 	return service.save(entity);
	 }
	 
	 @PutMapping
	 public ToDoListEntity putToDoList(@RequestBody ToDoListEntity entity) {
		 return service.save(entity);
	 }
	 
	 @DeleteMapping("/{id}")
	 public String deleteToDoListById(@PathVariable Long id) {
		 return service.deleteById(id);
	 }
	 
	 
}
