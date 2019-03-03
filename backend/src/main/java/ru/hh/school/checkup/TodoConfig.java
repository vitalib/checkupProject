package ru.hh.school.checkup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.common.properties.FileSettings;
import ru.hh.nab.datasource.DataSourceFactory;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.hibernate.NabHibernateCommonConfig;
import ru.hh.nab.hibernate.NabHibernateProdConfig;
import ru.hh.nab.starter.NabProdConfig;
import ru.hh.school.checkup.dao.TodoDAOInMemory;
import ru.hh.school.checkup.entities.Todo;
import ru.hh.school.checkup.services.TodoService;


import javax.sql.DataSource;


@Configuration
@Import({NabProdConfig.class, NabHibernateProdConfig.class, NabHibernateCommonConfig.class})
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
    DataSource dataSource(DataSourceFactory dataSourceFactory, FileSettings fileSettings) {
        return dataSourceFactory.create("master", false, fileSettings);
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
