plugins {
	kotlin("jvm") version "1.9.20"
	id("java-library")
	id("maven-publish")
	id("nebula.release") version "17.2.2"
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