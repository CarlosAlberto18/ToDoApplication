package com.javabackenddeveloper.todoapp.service;

import com.javabackenddeveloper.todoapp.dto.TaskInDTO;
import com.javabackenddeveloper.todoapp.entity.Task;
import com.javabackenddeveloper.todoapp.entity.TaskStatus;
import com.javabackenddeveloper.todoapp.exceptions.ToDoExceptions;
import com.javabackenddeveloper.todoapp.mapper.TaskInDTOToTask;
import com.javabackenddeveloper.todoapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskInDTOToTask taskInDTOToTask;

    public Task createTask(TaskInDTO taskInDTO){
        Task task = taskInDTOToTask.map(taskInDTO);
        return taskRepository.save(task);
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public List<Task> findAllByTasksStatus(TaskStatus taskStatus){
        return taskRepository.findAllByTaskStatus(taskStatus);
    }
    @Transactional
    public void updateTaskAsFinished(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not Found", HttpStatus.NOT_FOUND);
        }
        taskRepository.markTasksAsFinished(id);
    }

    public void deleteById(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not Found", HttpStatus.NOT_FOUND);
        }
        taskRepository.deleteById(id);
    }

}
