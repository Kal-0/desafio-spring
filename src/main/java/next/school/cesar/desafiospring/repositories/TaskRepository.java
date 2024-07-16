package next.school.cesar.desafiospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import next.school.cesar.desafiospring.entities.TaskEntity;



public interface TaskRepository extends JpaRepository<TaskEntity, Long>{
	
}

