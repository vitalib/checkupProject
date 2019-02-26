package ru.hh.school.checkup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.school.checkup.dao.TodoDAOInMemory;
import ru.hh.school.checkup.services.TodoService;
import ru.hh.nab.starter.NabProdConfig;

@Configuration
@Import(NabProdConfig.class)
public class TodoConfig {

    @Bean
    public TodoDAOInMemory todoDAOInMemory() {
        return new TodoDAOInMemory();
    }

    @Bean
    public TodoService todoService(){
        return new TodoService();
    }

}
