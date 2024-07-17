package next.school.cesar.desafiospring.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import next.school.cesar.desafiospring.entities.TaskEntity;
import next.school.cesar.desafiospring.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	public TaskEntity findById(Long id) {
		return repository.findById(id).orElse(null);

	}

	public List<TaskEntity> findAll() {
		return repository.findAll();
	}

	public TaskEntity save(TaskEntity entity) {
		entity.setCompleted(false);
		entity.setCreatedAt(LocalDateTime.now());
		entity.setUpdatedAt(LocalDateTime.now());
		return repository.save(entity);
	}

	public TaskEntity update(TaskEntity entity) {
		TaskEntity currentEntity = repository.findById(entity.getId()).orElse(null);

		if (entity.getName() != null) {
			currentEntity.setName(entity.getName());
		}
		if (entity.getDescription() != null) {
			currentEntity.setDescription(entity.getDescription());
		}
		if (entity.getDueDate() != null) {
			currentEntity.setDueDate(entity.getDueDate());
		}
		if (entity.getCompleted() != null) {
			currentEntity.setCompleted(entity.getCompleted());
		}

		currentEntity.setUpdatedAt(LocalDateTime.now());

		return repository.save(currentEntity);
	}

	public String deleteById(Long id) {
		repository.deleteById(id);
		return "success delete";
	}
}
