package com.managing.tasks.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.managing.tasks.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

