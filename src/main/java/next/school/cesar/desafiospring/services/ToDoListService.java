package next.school.cesar.desafiospring.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import next.school.cesar.desafiospring.entities.ToDoListEntity;
import next.school.cesar.desafiospring.repositories.ToDoListRepository;

@Service
public class ToDoListService {

		@Autowired
		private ToDoListRepository repository;
		
		public ToDoListEntity save(ToDoListEntity toDoList) {
			toDoList.setCreatedAt(LocalDateTime.now());
			toDoList.setUpdatedAt(LocalDateTime.now());
			return repository.save(toDoList);
		}
		
		public ToDoListEntity findById(Long id) {
			return repository.findById(id).orElse(null);
			
		}
		
		public List<ToDoListEntity> findAll() {
			return repository.findAll();
		}
		
		public String deleteById(Long id) {
			repository.deleteById(id);
			return "success delete";
		}
}
