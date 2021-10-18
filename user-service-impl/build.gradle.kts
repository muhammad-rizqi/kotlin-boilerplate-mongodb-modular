import org.gradle.api.tasks.bundling.Jar
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")

  kotlin("jvm")
  kotlin("plugin.spring")
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false

jar.enabled = true

dependencies {
  	implementation(project(":user-models"))
  	implementation(project(":user-repository"))
  	implementation(project(":user-repository-impl"))
  	implementation(project(":user-service"))

  	implementation(kotlin("reflect"))
  	implementation(kotlin("stdlib-jdk8"))
  	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
  	// implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  	implementation("org.springframework.boot:spring-boot-starter-web")
  	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

  	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
