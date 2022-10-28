plugins {
    id("java")
}

java {
    val javaVersion: String by project
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
    targetCompatibility = JavaVersion.toVersion(javaVersion)
}

dependencies {
    implementation(project(":base-java"))

    val hibernateCoreVersion: String by project
    implementation("org.hibernate.orm:hibernate-core:${hibernateCoreVersion}")
    val mysqlConnectorVersion: String by project
    implementation("com.mysql:mysql-connector-j:${mysqlConnectorVersion}")

    val junitJupiterVersion: String by project
    val assertJVersion: String by project
    val testContainerVersion: String by project
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitJupiterVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${junitJupiterVersion}")
    testImplementation("org.assertj:assertj-core:${assertJVersion}")
    testImplementation("org.testcontainers:testcontainers:${testContainerVersion}")
    testImplementation("org.testcontainers:junit-jupiter:${testContainerVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitJupiterVersion}")
}

tasks {
    test {
        useJUnitPlatform()
    }
}