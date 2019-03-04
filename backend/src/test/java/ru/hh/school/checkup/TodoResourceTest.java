package ru.hh.school.checkup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import ru.hh.school.checkup.dao.TodoDAO;
import ru.hh.school.checkup.dao.TodoDAOInMemory;
import ru.hh.school.checkup.dto.TodoDTO;
import ru.hh.school.checkup.entities.Todo;
import ru.hh.school.checkup.exceptions.TodoNotFoundException;
import ru.hh.school.checkup.services.TodoService;
import ru.hh.nab.starter.NabApplication;
import ru.hh.nab.testbase.NabTestBase;
import ru.hh.school.checkup.resources.TodoResource;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@ContextConfiguration(classes = TodoTestConfig.class)
public class TodoResourceTest extends NabTestBase {

  @Inject
  TodoDAO todoDAOInMemory;

  @Inject
  TodoService todoService;


  @Before
  public void setUp() {
    todoDAOInMemory.clearAll();
  }

  @Test
  public void resource() {
    Response response = createRequest("/api/todos").get();
    System.out.println(response.readEntity(String.class));
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
  }

  @Test
  public void resourcePost() {
    Response response = target("/api/todos")
            .request()
            .buildPost(Entity.json(new Todo("kuku")))
            .invoke();
    assertThat(response.readEntity(String.class), containsString("kuku"));
  }

  @Test
  public void resourceGetSingleTodo() {
    Todo newTodo = todoDAOInMemory.save(new TodoDTO("kuku"));
    Response response = createRequest("/api/todos/" + newTodo.getId()).get();
    assertThat(response.readEntity(String.class), containsString("kuku"));
  }

  @Test
  public void resourceModifySingle() {
    TodoDTO todoDTO = new TodoDTO("kuku");
    TodoDTO saved = todoService.save(todoDTO);
    saved.setTitle("modified");
    TodoDTO modified = todoService.update(saved.getId(), saved);
    Response response =  target("/api/todos/" + saved.getId())
            .request()
            .buildPut(Entity.json(modified))
            .invoke();
    assertThat(response.readEntity(String.class), containsString("modified"));
  }

  @Test
  public void deleteTodo() {
    Todo todo = new Todo("kuku");
    Response response =  target("/api/todos/" + todo.getId())
            .request()
            .delete();
    assertEquals(todoService.findAll().toString(), "[]");
  }

  @Test (expected = TodoNotFoundException.class)
  public void throwExceptionWhenIncorrectIdPassed() {
    todoService.save(new TodoDTO("joker"));
    todoService.save(new TodoDTO("joker2"));
    todoService.findById(345345);
  }


  @Override
  protected NabApplication getApplication() {
    return NabApplication.builder().configureJersey().registerResources(TodoResource.class).bindToRoot().build();
  }
}
