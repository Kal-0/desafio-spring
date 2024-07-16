package next.school.cesar.desafiospring.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JsonBackReference
	ToDoListEntity toDoList;
	
	@Column(nullable = false)
	String name;
	
	String description;
	
	LocalDateTime dueDate;
	
	Boolean completed;
	
	LocalDateTime createdAt;
	
	LocalDateTime updatedAt;
	
}
