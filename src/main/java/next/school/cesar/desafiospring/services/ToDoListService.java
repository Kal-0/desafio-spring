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

	public ToDoListEntity findById(Long id) {
		return repository.findById(id).orElse(null);

	}

	public List<ToDoListEntity> findAll() {
		return repository.findAll();
	}

	public ToDoListEntity save(ToDoListEntity entity) {
		entity.setCreatedAt(LocalDateTime.now());
		entity.setUpdatedAt(LocalDateTime.now());
		return repository.save(entity);
	}

	public ToDoListEntity update(ToDoListEntity entity) {
		ToDoListEntity currentEntity = repository.findById(entity.getId()).orElse(null);

		if (entity.getName() != null) {
			currentEntity.setName(entity.getName());
		}
		if (entity.getDescription() != null) {
			currentEntity.setDescription(entity.getDescription());
		}

		currentEntity.setUpdatedAt(LocalDateTime.now());

		return repository.save(currentEntity);
	}

	public String deleteById(Long id) {
		repository.deleteById(id);
		return "success delete";
	}
}
