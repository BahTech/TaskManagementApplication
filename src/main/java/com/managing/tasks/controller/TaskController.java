package com.managing.tasks.controller;



import com.managing.tasks.model.Task;
import com.managing.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            // Handle the case where the task is not found (e.g., send an appropriate HTTP response)
            throw new RuntimeException("Task with ID " + id + " not found.");
        }
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}