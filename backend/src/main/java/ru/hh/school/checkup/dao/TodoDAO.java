package ru.hh.school.checkup.dao;

import ru.hh.school.checkup.dto.TodoDTO;
import ru.hh.school.checkup.entities.Todo;

import java.util.List;

public interface TodoDAO {

    public Todo save(TodoDTO todoDTO);

    public void clearAll();

    public Todo getById(Integer id);

    public Todo deleteById(Integer id);

    public List<Todo> getAll();

    public Todo updateById(Integer id, TodoDTO todoDTO);
}
