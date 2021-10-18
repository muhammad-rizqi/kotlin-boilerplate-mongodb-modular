import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.5.5"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.5.31"
  kotlin("plugin.spring") version "1.5.31"
}

allprojects {
  repositories {
    mavenCentral()
    maven(url = "https://plugins.gradle.org/m2/")
  }
}

java.sourceCompatibility = JavaVersion.VERSION_11

subprojects {
  group = "com.rizqi.user"

  version = "0.0.1-SNAPSHOT"

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "11"
    }
  }

  tasks.withType<Test> { useJUnitPlatform() }

  apply { plugin("io.spring.dependency-management") }
}
/**
 * allprojects {
 *
 * }
 */
val jar: Jar by tasks

jar.enabled = true
/**
 * allOpen { annotation("javax.persistence.Entity") annotation("javax.persistence.MappedSuperclass")
 * annotation("javax.persistence.Embeddable") }
 */
dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-actuator")
//  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springdoc:springdoc-openapi-ui:1.4.6")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.slf4j:slf4j-api:1.7.25")
  // classpath("org.openapitools:openapi-generator-gradle-plugin:4.3.1")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

springBoot { mainClass.set("com.rizqi.user.MainApplication") }
