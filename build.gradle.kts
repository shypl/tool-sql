plugins {
	kotlin("jvm") version "2.0.0"
	id("java-library")
	id("maven-publish")
	id("nebula.release") version "19.0.8"
}

group = "org.shypl.tool"

repositories {
	mavenCentral()
}

kotlin {
	jvmToolchain(17)
}

java {
	withSourcesJar()
}

publishing {
	publications.create<MavenPublication>("Library") {
		from(components["java"])
	}
}