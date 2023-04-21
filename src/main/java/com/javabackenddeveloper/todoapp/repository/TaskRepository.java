package com.javabackenddeveloper.todoapp.repository;

import com.javabackenddeveloper.todoapp.entity.Task;
import com.javabackenddeveloper.todoapp.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByTaskStatus(TaskStatus taskStatus);

    @Modifying
    @Query(value = "UPDATE task SET FINISHED=true WHERE ID=:id",nativeQuery = true)
    public void markTasksAsFinished(@Param("id") Long id);
}
