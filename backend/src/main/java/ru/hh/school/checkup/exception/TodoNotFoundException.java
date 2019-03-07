package ru.hh.school.checkup.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class TodoNotFoundException extends WebApplicationException {

    public TodoNotFoundException(String message) {
        super(
            message,
            Response.status(Response.Status.BAD_REQUEST).build()
        );
    }
}
