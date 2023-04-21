package com.javabackenddeveloper.todoapp.controller;

import com.javabackenddeveloper.todoapp.dto.TaskInDTO;
import com.javabackenddeveloper.todoapp.entity.Task;
import com.javabackenddeveloper.todoapp.entity.TaskStatus;
import com.javabackenddeveloper.todoapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return taskService.createTask(taskInDTO);
    }
    @GetMapping
    public List<Task> findAll(){
        return taskService.findAll();
    }
    @GetMapping("/status/{status}")
    public List<Task> findAllByTasksStatus(@PathVariable(name = "status") TaskStatus taskStatus){
        return taskService.findAllByTasksStatus(taskStatus);
    }
    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable(name = "id") Long id){
        taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id){
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
