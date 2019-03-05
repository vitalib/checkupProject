package ru.hh.school.checkup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import ru.hh.school.checkup.dto.TodoDTO;
import ru.hh.school.checkup.entities.Todo;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;


public class TodoDAO {

    @Inject
    SessionFactory sessionFactory;

    public TodoDAO() {

    }

    public Todo save(TodoDTO todoDTO) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        todo.setCompleted(false);
        todo.setCreatedAt(new Date());
        sessionFactory.getCurrentSession().persist(todo);
        return todo;
    }

    public void clearAll() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Todo")
                .executeUpdate();
    }

    public Todo getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Todo.class, id);
    }

    public Todo deleteById(Integer id) {
        Todo todo = getById(id);
        if (todo == null) {
            return null;
        }
        sessionFactory.getCurrentSession().createQuery("DELETE from Todo WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
        return todo;
    }

    public List<Todo> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Todo", Todo.class).list();
    }

    public Todo updateById(Integer id, TodoDTO todoDTO) {
        Todo todo = getById(id);
        if (todo == null) {
            return null;
        }
        BeanUtils.copyProperties(todoDTO, todo);
        todo.setId(id);
        sessionFactory.getCurrentSession().update(todo);
        return todo;
    }
}