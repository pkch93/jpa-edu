rootProject.name = "jpa-edu"

pluginManagement {
    val kotlinJvmPluginVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinJvmPluginVersion
        kotlin("plugin.jpa") version kotlinJvmPluginVersion
        kotlin("plugin.spring") version kotlinJvmPluginVersion
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
    }
}
