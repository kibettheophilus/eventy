plugins {
    `java-library`
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "com.theophiluskibet"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencyManagement{
    imports{
        mavenBom("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:8.0.0")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:8.0.0"))
    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
    implementation("net.devh:grpc-client-spring-boot-starter:2.14.0.RELEASE")
    implementation(project(":proto"))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}