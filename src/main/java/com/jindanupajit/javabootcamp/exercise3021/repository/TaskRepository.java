package com.jindanupajit.javabootcamp.exercise3021.repository;

import com.jindanupajit.javabootcamp.exercise3021.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long>{
}
