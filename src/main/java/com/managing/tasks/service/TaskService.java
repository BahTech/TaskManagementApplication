package com.managing.tasks.service;



import com.managing.tasks.model.Task;
import com.managing.tasks.service.*;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Long id);

    Task createTask(Task task);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);
}

