package com.raden.diet_gram.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raden.diet_gram.models.Task;


@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

	List<Task> findAll();
	
	@Transactional
	@Modifying
	@Query("update Task task set task.finished = :finish where task.id = :id")
	void updateFinish(@Param(value = "id") long id, @Param(value = "finish") Boolean finish);
}
