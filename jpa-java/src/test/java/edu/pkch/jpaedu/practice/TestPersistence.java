package edu.pkch.jpaedu.practice;

import jakarta.persistence.EntityManager;

import java.util.Map;

import static edu.pkch.jpaedu.practice.JpaEduTest.MYSQL_ROOT_PASSWORD;

public class TestPersistence {

    private final PersistenceContainer persistenceContainer;

    public TestPersistence(String jdbcUrl) {
        Map<String, Object> jpaProperties = Map.of(
                "jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver",
                "jakarta.persistence.jdbc.url", jdbcUrl,
                "jakarta.persistence.jdbc.user", "root",
                "jakarta.persistence.jdbc.password", MYSQL_ROOT_PASSWORD
        );

        Map<String, Object> hibernateProperties = Map.of(
                "hibernate.hbm2ddl.auto", "create-drop",
                "hibernate.show_sql", true,
                "hibernate.format_sql", true
        );

        persistenceContainer = new PersistenceContainer(jpaProperties, hibernateProperties);
    }

    public EntityManager entityManager() {
        return persistenceContainer.entityManager();
    }

    public void close() {
        persistenceContainer.close();
    }
}
