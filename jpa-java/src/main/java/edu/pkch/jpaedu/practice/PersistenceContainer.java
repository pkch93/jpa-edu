package edu.pkch.jpaedu.practice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.dialect.Database;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.Map;

public class PersistenceContainer implements AutoCloseable {

    private final EntityManagerFactory emf;

    public PersistenceContainer(Map<String, Object> jpaProperties,
                                Map<String, Object> hibernateProperties) {
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new JpaEduPersistenceUnitInfo(jpaProperties), hibernateProperties);
    }

    public EntityManager entityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void close() {
        emf.close();
    }
}
