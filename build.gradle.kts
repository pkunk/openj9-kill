plugins {
    java
    id("org.springframework.boot") version "2.3.8.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-jdbc")
    implementation("com.microsoft.azure:applicationinsights-web:2.6.2")
    implementation("org.liquibase:liquibase-core")
    implementation("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
        vendor.set(JvmVendorSpec.ADOPTOPENJDK)
        implementation.set(JvmImplementation.J9)
    }
}
