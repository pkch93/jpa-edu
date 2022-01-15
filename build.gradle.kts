plugins {
    id("java")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

allprojects {
    group = "edu.pkch"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("java")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        runtimeOnly("mysql:mysql-connector-java")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks {
        test {
            useJUnitPlatform()
        }
    }
}