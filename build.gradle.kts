plugins {
	kotlin("jvm") version "2.1.0"
	id("java-library")
	id("maven-publish")
	id("nebula.release") version "19.0.10"
}

group = "org.shypl.tool"

repositories {
	mavenCentral()
}

kotlin {
	jvmToolchain(21)
}

java {
	withSourcesJar()
}

publishing {
	publications.create<MavenPublication>("Library") {
		from(components["java"])
	}
}