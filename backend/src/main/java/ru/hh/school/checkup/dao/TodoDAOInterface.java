package ru.hh.school.checkup.dao;

import ru.hh.school.checkup.dto.TodoDTO;
import ru.hh.school.checkup.entities.Todo;

import java.util.List;

public interface TodoDAOInterface {

    public Todo save(TodoDTO todoDTO);

    public void clearAll();

    public Todo getById(String id);

    public Todo deleteById(String id);

    public List<Todo> getAll();

    public Todo updateById(String id, TodoDTO todoDTO);
}
