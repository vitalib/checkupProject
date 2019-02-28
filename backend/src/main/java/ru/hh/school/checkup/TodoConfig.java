package ru.hh.school.checkup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.core.CoreProdConfig;
import ru.hh.nab.core.util.FileSettings;
import ru.hh.nab.hibernate.DataSourceFactory;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.hibernate.datasource.DataSourceType;
import ru.hh.school.checkup.dao.TodoDAOInMemory;
import ru.hh.school.checkup.entities.Todo;
import ru.hh.school.checkup.services.TodoService;
import ru.hh.nab.hibernate.HibernateProdConfig;

import javax.sql.DataSource;


@Configuration
@Import({CoreProdConfig.class, HibernateProdConfig.class})
public class TodoConfig {

    @Bean
    MappingConfig mappingConfig() {
        return new MappingConfig(
            Todo.class
        );
    }

    @Bean
    String serviceName() {
        return "checkup";
    }

    @Bean
    DataSource dataSource(DataSourceFactory dataSourceFactory, FileSettings settings) {
        return dataSourceFactory.create(DataSourceType.MASTER, settings);
    }

    @Bean
    public TodoDAOInMemory todoDAOInMemory() {
        return new TodoDAOInMemory();
    }

    @Bean
    public TodoService todoService(){
        return new TodoService();
    }

}
