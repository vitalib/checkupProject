package ru.hh.school.checkup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.school.checkup.filters.CORSResponseFilter;
import ru.hh.school.checkup.resources.TodoResource;

@Configuration
@Import({TodoResource.class, CORSResponseFilter.class})
public class TodoJerseyConfig {
    @Bean
    CORSResponseFilter corsResponseFilter() {
        return new CORSResponseFilter();
    }
}
