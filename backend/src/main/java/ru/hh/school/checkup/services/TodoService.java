package ru.hh.school.checkup.services;

import org.springframework.beans.BeanUtils;
import ru.hh.school.checkup.dao.TodoDAO;
import ru.hh.school.checkup.dto.TodoDTO;
import ru.hh.school.checkup.entities.Todo;
import ru.hh.school.checkup.exceptions.TodoNotFoundException;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

public class TodoService {

    @Inject
    private TodoDAO todoDAO;

    @Transactional
    public List<Todo> findAll() {
        return todoDAO.getAll();
    }

    @Transactional
    public TodoDTO save(TodoDTO todoDTO) {
        Todo savedTodo = todoDAO.save(todoDTO);
        return new TodoDTO(savedTodo);
    }

    @Transactional
    public TodoDTO findById(Integer id) {
        Todo todo = todoDAO.getById(id);
        if (todo == null) {
            throw new TodoNotFoundException(String.format("Todo with id = %s does not exists", id));
        } else {
            TodoDTO todoDTO = new TodoDTO();
            BeanUtils.copyProperties(todo, todoDTO);
            return todoDTO;
        }
    }

    @Transactional
    public TodoDTO update(Integer id, TodoDTO todoDTO) {
        Todo updatedTodo = todoDAO.updateById(id, todoDTO);
        if (updatedTodo == null) {
            throw new TodoNotFoundException(String.format("Todo with id = %s does not exists", id));
        } else {
            return new TodoDTO(updatedTodo);
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        Todo todo = todoDAO.deleteById(id);
        if (todo == null) {
            throw new TodoNotFoundException(String.format("Todo with id = %s does not exists", id));
        }
    }

}
