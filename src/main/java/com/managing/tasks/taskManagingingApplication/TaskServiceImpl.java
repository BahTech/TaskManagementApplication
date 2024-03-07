package com.managing.tasks.taskManagingingApplication;


import com.managing.tasks.model.Task;
import com.managing.tasks.repository.TaskRepository;
import com.managing.tasks.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            // Handle the exception for task creation (e.g., unique constraint violation)
            // You can log the exception or re-throw it based on your needs.
            throw new RuntimeException("Error creating task: " + e.getMessage());
        }
    }

    @Override
    public Task updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            try {
                task.setId(id);
                return taskRepository.save(task);
            } catch (Exception e) {
                // Handle the exception for task update
                throw new RuntimeException("Error updating task: " + e.getMessage());
            }
        }
        // Handle the case where the task is not found (e.g., throw a specific exception)
        throw new RuntimeException("Task with ID " + id + " not found.");
    }

    @Override
    public void deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            // Handle the exception for task deletion
            throw new RuntimeException("Error deleting task: " + e.getMessage());
        }
    }
}

