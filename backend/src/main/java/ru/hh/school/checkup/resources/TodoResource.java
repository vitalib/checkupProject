package ru.hh.school.checkup.resources;

import ru.hh.school.checkup.dto.TodoDTO;
import ru.hh.school.checkup.services.TodoService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api")
public class TodoResource {

    @Inject
    TodoService todoService;

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTodos() {
        return Response.ok()
                .entity(todoService.findAll())
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/todos")
    public Response createTodo(TodoDTO todo) {
        return Response.ok()
            .entity(todoService.save(todo))
            .build();

    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/todos/{id}")
    public Response getTodoById(@PathParam("id") String id) {
        return Response.ok()
                .entity(todoService.findById(id))
                .build();
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    @Path("/todos/{id}")
    public Response updateTodo(@PathParam("id") String id, TodoDTO todo) {
        TodoDTO updatedTodoDTO = todoService.update(id, todo);
        return Response.ok()
                .entity(updatedTodoDTO)
                .build();
    }

    @DELETE
    @Path("/todos/{id}")
    public Response deleteTodo(@PathParam("id") String id) {
        todoService.deleteById(id);
        return Response.ok().build();
    }
}
