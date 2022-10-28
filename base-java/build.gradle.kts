plugins {
    id("java")
}

java {
    val javaVersion: String by project
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
    targetCompatibility = JavaVersion.toVersion(javaVersion)
}

dependencies {
    val jpaVersion: String by project
    implementation("jakarta.persistence:jakarta.persistence-api:${jpaVersion}")

    val junitJupiterVersion: String by project
    val assertJVersion: String by project
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitJupiterVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${junitJupiterVersion}")
    testImplementation("org.assertj:assertj-core:${assertJVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitJupiterVersion}")
}

tasks {
    test {
        useJUnitPlatform()
    }
}