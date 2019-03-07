package ru.hh.school.checkup;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import ru.hh.metrics.StatsDSender;
import ru.hh.nab.common.properties.FileSettings;
import ru.hh.nab.datasource.DataSourceFactory;
import ru.hh.nab.datasource.DataSourceSettings;
import ru.hh.nab.datasource.DataSourceType;
import ru.hh.nab.datasource.monitoring.MetricsTrackerFactoryProvider;
import ru.hh.nab.testbase.hibernate.NabHibernateTestBaseConfig;
import ru.hh.nab.testbase.postgres.embedded.EmbeddedPostgresDataSourceFactory;
import ru.hh.school.checkup.service.TodoService;
import ru.hh.nab.testbase.NabTestConfig;

import javax.sql.DataSource;

import static org.mockito.Mockito.mock;
import static ru.hh.nab.testbase.NabTestConfig.TEST_SERVICE_NAME;

@Configuration
@Import({NabTestConfig.class,
         NabHibernateTestBaseConfig.class,
         CommonConfig.class})
public class TestConfig {

    @Bean
    DataSource dataSource() throws Exception {
        Properties properties = new Properties();

        var testDb = EmbeddedPostgresDataSourceFactory.getEmbeddedPostgres();
        final StringSubstitutor jdbcUrlParamsSubstitutor = new StringSubstitutor(Map.of(
                "port", testDb.getPort(),
                "host", "localhost",
                "user", EmbeddedPostgresDataSourceFactory.DEFAULT_USER
        ));
        properties.setProperty(getProperty(DataSourceSettings.JDBC_URL),
                jdbcUrlParamsSubstitutor.replace(EmbeddedPostgresDataSourceFactory.DEFAULT_JDBC_URL));

        properties.setProperty(getProperty(DataSourceSettings.USER), EmbeddedPostgresDataSourceFactory.DEFAULT_USER);
        properties.setProperty(getProperty(DataSourceSettings.PASSWORD), EmbeddedPostgresDataSourceFactory.DEFAULT_USER);
        properties.setProperty(getProperty(DataSourceSettings.POOL_SETTINGS_PREFIX + ".maximumPoolSize"), "2");


        var statsDSender = mock(StatsDSender.class);
        var dataSourceFactory = new DataSourceFactory(new MetricsTrackerFactoryProvider(TEST_SERVICE_NAME, statsDSender));
        return dataSourceFactory.create(String.valueOf(DataSourceType.MASTER), false, new FileSettings(properties));
    }

    private static String getProperty(String propertyName) {
        return String.format("%s.%s", DataSourceType.MASTER, propertyName);
    }

    @Bean
    PropertiesFactoryBean serviceProperties() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("service-test.properties"));
        return propertiesFactoryBean;
    }
}

