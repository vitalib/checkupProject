package ru.hh.school.checkup.exceptions;

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
