package com.javabackenddeveloper.todoapp.dto;

import com.javabackenddeveloper.todoapp.entity.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskInDTO {
    private String title;
    private String description;
    private LocalDateTime eta;
}
