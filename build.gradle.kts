plugins {
    java
    kotlin("jvm") version "2.0.0"
    `maven-publish`
}

group = "com.naulian.kproc"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(fileTree("libs") { include("*.jar") })
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven"){
                from(components["java"])
                groupId = "com.naulian"
                artifactId = "processing"
                version = "0.0.1-test01"
            }
        }
    }
}
