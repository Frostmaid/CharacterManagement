buildscript {
  repositories {
    jcenter()
  }
}

plugins {
  kotlin("multiplatform") version "1.3.61"
}

val artifactName = "jenseits.der.nebel"
val ktorVersion = "1.2.2"
val logbackVersion = "1.2.3"

group = artifactName
version = "1.0-SNAPSHOT"

repositories {
  jcenter()
  mavenCentral()
}

kotlin {
  jvm()

  js {
    browser()
  }

  sourceSets {
    kotlin.sourceSets["commonMain"].dependencies {
      implementation(kotlin("stdlib-common"))
    }

    kotlin.sourceSets["commonTest"].dependencies {
      implementation(kotlin("test-common"))
      implementation(kotlin("test-annotations-common"))
    }

    kotlin.sourceSets["jvmMain"].dependencies {
      implementation(kotlin("stdlib-jdk8"))
      implementation("io.ktor:ktor-server-netty:$ktorVersion")
      implementation("io.ktor:ktor-html-builder:$ktorVersion")
      implementation("ch.qos.logback:logback-classic:$logbackVersion")
    }

    kotlin.sourceSets["jvmTest"].dependencies {
      implementation(kotlin("test"))
      implementation(kotlin("test-junit"))
    }

    kotlin.sourceSets["jsMain"].dependencies {
      implementation(kotlin("stdlib-js"))
      implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
    }

    kotlin.sourceSets["jsTest"].dependencies {
      implementation(kotlin("test-js"))
    }
  }
}

val run by tasks.creating(JavaExec::class) {
  group = "application"
  main = "${artifactName}.MainKt"
  kotlin {
    val main = targets["jvm"].compilations["main"]
    dependsOn(main.compileAllTaskName)
    classpath(
      { main.output.allOutputs.files },
      { configurations["jvmRuntimeClasspath"] }
    )
  }
  ///disable app icon on macOS
  systemProperty("java.awt.headless", "true")
}