package next.school.cesar.desafiospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import next.school.cesar.desafiospring.entities.ToDoListEntity;



public interface ToDoListRepository extends JpaRepository<ToDoListEntity, Long>{
	
}

