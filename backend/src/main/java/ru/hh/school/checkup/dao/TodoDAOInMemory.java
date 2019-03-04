package ru.hh.school.checkup.dao;

import org.springframework.beans.BeanUtils;
import ru.hh.school.checkup.dto.TodoDTO;
import ru.hh.school.checkup.entities.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoDAOInMemory implements TodoDAO {

    private static int counter = 0;
    private List<Todo> todos = new ArrayList<>();

    @Override
    public Todo getById(String id) {
        return todos.stream().filter(todo -> id.equals(todo.getId())).findFirst().orElse(null);
    }

    @Override
    public List<Todo> getAll() {
        return todos;
    }

    @Override
    public Todo updateById(String id, TodoDTO todoDTO) {
        Todo savedTodo = getById(id);
        if (savedTodo == null) {
            return null;
        }
        int index = todos.indexOf(savedTodo);
        BeanUtils.copyProperties(todoDTO, savedTodo);
        savedTodo.setId(id);
        todos.set(index, savedTodo);
        return savedTodo;
    }


    @Override
    public Todo save(TodoDTO todoDTO) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        todo.setCompleted(false);
        todo.setCreatedAt(new Date());
        todo.setId(Integer.toString(counter++));
        todos.add(todo);
        return todo;
    }

    @Override
    public void clearAll() {
        todos = new ArrayList<>();

    }

    @Override
    public Todo deleteById(String id) {
        Todo todo = getById(id);
        if (todo == null) {
            return null;
        }
        int index = todos.indexOf(todo);
        todos.remove(index);
        return todo;

    }
}
