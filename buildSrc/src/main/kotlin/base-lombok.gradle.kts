import org.gradle.kotlin.dsl.java

plugins{
    java
}

dependencies{
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}