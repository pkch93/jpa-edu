package edu.pkch.jpaedu.practice;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.sql.DataSource;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JpaEduPersistenceUnitInfo implements PersistenceUnitInfo {

    private Map<String, Object> jpaProperties;

    public JpaEduPersistenceUnitInfo(Map<String, Object> jpaProperties) {
        this.jpaProperties = jpaProperties;
    }

    @Override
    public String getPersistenceUnitName() {
        return "jpaedu";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return HibernatePersistenceProvider.class.getName();
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return Collections.emptyList();
    }

    @Override
    public List<URL> getJarFileUrls() {
        return Collections.emptyList();
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of(
                "edu.pkch.jpaedu.entity.Post",
                "edu.pkch.jpaedu.entity.PostHashTag",
                "edu.pkch.jpaedu.entity.Comment",
                "edu.pkch.jpaedu.entity.CommentHashTag"
        );
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return SharedCacheMode.UNSPECIFIED;
    }

    @Override
    public ValidationMode getValidationMode() {
        return ValidationMode.AUTO;
    }

    @Override
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.putAll(jpaProperties);
        return properties;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return "3.1";
    }

    @Override
    public ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    @Override
    public void addTransformer(ClassTransformer transformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
