package com.javabackenddeveloper.todoapp.mapper;

public interface IMapper <I,O>{
    O map(I in);
}
