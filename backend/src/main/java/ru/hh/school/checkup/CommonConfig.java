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
import ru.hh.school.checkup.dao.TodoDAO;
import ru.hh.school.checkup.entities.Todo;
import ru.hh.school.checkup.services.TodoService;


import javax.sql.DataSource;


@Configuration
@Import({TodoService.class,
         TodoDAO.class})
public class CommonConfig {

    @Bean
    MappingConfig mappingConfig() {
        return new MappingConfig(
            Todo.class
        );
    }
}