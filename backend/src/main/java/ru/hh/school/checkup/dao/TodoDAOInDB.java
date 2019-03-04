package ru.hh.school.checkup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import ru.hh.school.checkup.dto.TodoDTO;
import ru.hh.school.checkup.entities.Todo;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;


public class TodoDAOInDB implements TodoDAO {

    @Inject
    SessionFactory sessionFactory;

    private static int counter = 0;

    @Inject
    public TodoDAOInDB() {

    }

    @Override
    public Todo save(TodoDTO todoDTO) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        todo.setCompleted(false);
        todo.setCreatedAt(new Date());
        todo.setId(Integer.toString(counter++));
        sessionFactory.getCurrentSession().persist(todo);
        return todo;
    }

    @Override
    public void clearAll() {

    }

    @Override
    public Todo getById(String id) {
        return sessionFactory.getCurrentSession().get(Todo.class, id);
    }

    @Override
    public Todo deleteById(String id) {
        return null;
    }

    @Override
    public List<Todo> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Todo", Todo.class).list();
    }

    @Override
    public Todo updateById(String id, TodoDTO todoDTO) {
        return null;
    }
}
