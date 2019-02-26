package ru.hh.school.checkup;

import ru.hh.school.checkup.filters.CORSResponseFilter;
import ru.hh.nab.starter.NabApplication;

public class TodoMain {

  public static void main(String[] args) {
    NabApplication.builder()
            .configureJersey(TodoJerseyConfig.class)
            .registerResources(CORSResponseFilter.class).bindToRoot()
            .build().run(TodoConfig.class);
  }
}
