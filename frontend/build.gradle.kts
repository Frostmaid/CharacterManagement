plugins {
  kotlin("js")
}

repositories {
  mavenCentral()
  jcenter()
}

kotlin {
  target {
    browser()

    sourceSets {
      main {
        dependencies {
          implementation(kotlin("stdlib-js"))
          implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
          implementation(project(":shared"))
        }
      }
    }
  }
}
