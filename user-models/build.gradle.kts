import org.gradle.api.tasks.bundling.Jar
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("jvm")
	kotlin("plugin.spring")
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false

jar.enabled = true


dependencies {
	implementation(kotlin("reflect"))
  	implementation(kotlin("stdlib-jdk8"))
  	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
}
