import com.google.protobuf.gradle.id

plugins {
    id("java")
    id("com.google.protobuf") version "0.9.4"
}

group = "com.theophiluskibet"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("io.grpc:grpc-netty-shaded:1.20.0")
    compileOnly("io.grpc:grpc-protobuf:1.20.0")
    compileOnly("io.grpc:grpc-stub:1.20.0")
//    compileOnly("com.google.protobuf:protobuf-java:3.21.7")
//    compileOnly("io.grpc:grpc-all:1.49.1")
//    compileOnly("javax.annotation:javax.annotation-api:1.3.2")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

protobuf {
    protoc { artifact = "com.google.protobuf:protoc:3.7.1:osx-x86_64" }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.20.0:osx-x86_64"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}