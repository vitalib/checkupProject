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
    public Todo getById(Integer idInt) {
        return todos.stream().filter(todo -> idInt == todo.getId())
                .findFirst().orElse(null);
    }

    @Override
    public List<Todo> getAll() {
        return todos;
    }

    @Override
    public Todo updateById(Integer idInt, TodoDTO todoDTO) {
        String id = idInt.toString();
        Todo savedTodo = getById(idInt);
        if (savedTodo == null) {
            return null;
        }
        int index = todos.indexOf(savedTodo);
        BeanUtils.copyProperties(todoDTO, savedTodo);
        savedTodo.setId(idInt);
        todos.set(index, savedTodo);
        return savedTodo;
    }


    @Override
    public Todo save(TodoDTO todoDTO) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        todo.setCompleted(false);
        todo.setCreatedAt(new Date());
        todo.setId(counter++);
        todos.add(todo);
        return todo;
    }

    @Override
    public void clearAll() {
        todos = new ArrayList<>();

    }

    @Override
    public Todo deleteById(Integer id) {
        Todo todo = getById(id);
        if (todo == null) {
            return null;
        }
        int index = todos.indexOf(todo);
        todos.remove(index);
        return todo;

    }
}
