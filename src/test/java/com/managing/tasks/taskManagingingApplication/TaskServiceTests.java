package com.managing.tasks.taskManagingingApplication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.managing.tasks.model.Task;
import com.managing.tasks.repository.TaskRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTests {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    public void createTask_ValidTask_ReturnsCreatedTask() {
        // Arrange
        Task inputTask = new Task();
        inputTask.setTitle("Sample Task");
        inputTask.setDescription("This is a sample task");

        Task createdTask = new Task();
        createdTask.setId(1L);
        createdTask.setTitle("Sample Task");
        createdTask.setDescription("This is a sample task");

        when(taskRepository.save(any(Task.class))).thenReturn(createdTask);

        // Act
        Task result = taskService.createTask(inputTask);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Sample Task", result.getTitle());
        assertEquals("This is a sample task", result.getDescription());

        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    public void updateTask_ExistingTask_ReturnsUpdatedTask() {
        // Arrange
        Long taskId = 1L;

        Task existingTask = new Task();
        existingTask.setId(taskId);
        existingTask.setTitle("Existing Task");
        existingTask.setDescription("This is an existing task");

        Task updatedTask = new Task();
        updatedTask.setId(taskId);
        updatedTask.setTitle("Updated Task");
        updatedTask.setDescription("This task has been updated");

        when(taskRepository.existsById(taskId)).thenReturn(true);
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        // Act
        Task result = taskService.updateTask(taskId, updatedTask);

        // Assert
        assertNotNull(result);
        assertEquals(taskId, result.getId());
        assertEquals("Updated Task", result.getTitle());
        assertEquals("This task has been updated", result.getDescription());

        verify(taskRepository, times(1)).existsById(taskId);
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    public void deleteTask_ExistingTask_SuccessfulDeletion() {
        // Arrange
        Long taskId = 1L;

        when(taskRepository.existsById(taskId)).thenReturn(true);

        // Act
        taskService.deleteTask(taskId);

        // Assert
        verify(taskRepository, times(1)).existsById(taskId);
        verify(taskRepository, times(1)).deleteById(taskId);
    }
}
