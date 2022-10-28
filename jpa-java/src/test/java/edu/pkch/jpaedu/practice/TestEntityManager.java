package edu.pkch.jpaedu.practice;

import java.util.Map;

public class TestEntityManager {

    private final PersistenceContainer persistenceContainer;

    public TestEntityManager(String jdbcUrl) {
        Map<String, Object> jpaProperties = Map.of(
                "jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver",
                "jakarta.persistence.jdbc.url", jdbcUrl,
                "jakarta.persistence.jdbc.user", "root",
                "jakarta.persistence.jdbc.password", "12345678"
        );

        Map<String, Object> hibernateProperties = Map.of(
                "hibernate.hbm2ddl.auto", "create-drop",
                "hibernate.show_sql", true,
                "hibernate.format_sql", true
        );

        persistenceContainer = new PersistenceContainer(jpaProperties, hibernateProperties);
    }

}