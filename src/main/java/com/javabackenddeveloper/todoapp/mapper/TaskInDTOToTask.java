package com.javabackenddeveloper.todoapp.mapper;

import com.javabackenddeveloper.todoapp.dto.TaskInDTO;
import com.javabackenddeveloper.todoapp.entity.Task;
import com.javabackenddeveloper.todoapp.entity.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{
    @Override
    public Task map(TaskInDTO in) {
        return Task.builder()
                .title(in.getTitle())
                .description(in.getDescription())
                .eta(in.getEta())
                .createDate(LocalDateTime.now())
                .finished(false)
                .taskStatus(TaskStatus.ON_TIME)
                .build();
    }
}
