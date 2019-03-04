package ru.hh.school.checkup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.BeanUtils;
import ru.hh.school.checkup.entities.Todo;

import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(value = {"createdAt"})
@XmlRootElement
public class TodoDTO {

    private String title;
    private Integer id;
    private Boolean completed;

    public TodoDTO(Todo todo) {
        BeanUtils.copyProperties(todo, this);
    }

    public TodoDTO() {

    }

    public TodoDTO(String title) {
        this.title = title;
    }

    public TodoDTO(String title, Integer id, Boolean completed) {
        this.title = title;
        this.id = id;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
