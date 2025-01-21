plugins {
  kotlin("jvm") version "2.0.0"
  id("java")
  alias(libs.plugins.intelliJPlatform)
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
   implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.21.0")
    intellijPlatform {
        create("IU", "2024.2.2") // WORKING if == 2024.2.2 but not if == 2024.3

        instrumentationTools()
        pluginVerifier()
        zipSigner()
    }
}

kotlin {
  jvmToolchain(21)
}

java {
   sourceCompatibility = JavaVersion.VERSION_21
}

tasks {
  wrapper {
    gradleVersion = "8.11"
  }
   processResources {
   }

   publishPlugin{
      dependsOn(processResources)
   }
}
