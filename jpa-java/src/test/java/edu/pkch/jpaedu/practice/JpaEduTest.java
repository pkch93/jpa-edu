package edu.pkch.jpaedu.practice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public abstract class JpaEduTest {
    public static final String MYSQL_ROOT_PASSWORD = "12345678";
    public static final String MYSQL_DATABASE = "jpaedu";

    protected static TestPersistence testPersistence;

    @Container
    private static final GenericContainer<?> MYSQL_CONTAINER = new GenericContainer<>(
            DockerImageName.parse("mysql").withTag("8.0.31")
    )
            .withEnv("MYSQL_ROOT_PASSWORD", "12345678")
            .withEnv("MYSQL_DATABASE", "jpaedu")
            .withExposedPorts(3306);

    @BeforeAll
    static void beforeAll() {
        String jdbcUrl =
            """
            jdbc:mysql://localhost:%d/%s?\
            useSSL=false&\
            allowPublicKeyRetrieval=true&\
            characterEncoding=utf8&\
            serverTimezone=Asia/Seoul\
            """.formatted(MYSQL_CONTAINER.getFirstMappedPort(), MYSQL_DATABASE);
        testPersistence = new TestPersistence(jdbcUrl);
    }

    @AfterAll
    static void afterAll() {
        testPersistence.close();
    }
}
