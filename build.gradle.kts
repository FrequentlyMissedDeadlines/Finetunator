plugins {
    id("java")
    jacoco
    kotlin("plugin.lombok") version "1.7.21"
    id("io.freefair.lombok") version "5.3.0"
}

group = "com.frequentlymisseddeadlines"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("commons-cli:commons-cli:1.5.0")
    implementation("org.yaml:snakeyaml:1.33")
    implementation("commons-io:commons-io:2.11.0")

}

jacoco {
    toolVersion = "0.8.8"
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    classDirectories.setFrom(classDirectories.files.map {
        fileTree(it).matching {
            exclude("com/frequentlymisseddeadlines/finetunator/Finetunator*")
        }
    })
    reports {
        xml.required.set(false)
        csv.required.set(false)
        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }
    finalizedBy(tasks.jacocoTestCoverageVerification)
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            classDirectories.setFrom(tasks.jacocoTestReport.get().classDirectories)
            limit {
                minimum = "1.00".toBigDecimal()
            }
        }
    }
}

tasks.wrapper {
    gradleVersion = "7.4"
}
