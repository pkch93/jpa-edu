import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.jpa")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "edu.pkch"
version = "1.0.0"

repositories {
    mavenCentral()
}

val javaVersion: String by project
java.sourceCompatibility = JavaVersion.toVersion(javaVersion)
java.targetCompatibility = JavaVersion.toVersion(javaVersion)

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = javaVersion

dependencies {
    implementation(kotlin("stdlib"))
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