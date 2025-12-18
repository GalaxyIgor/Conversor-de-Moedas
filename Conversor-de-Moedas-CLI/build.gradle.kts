plugins {
    kotlin("jvm") version "2.2.0"
    kotlin("plugin.serialization") version "2.2.0"
}

group = "logic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
// Ktor: O motor para fazer requisições HTTP
    val ktorVersion = "3.0.1" // Versão estável compatível com Kotlin 2.x
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    // Coroutines: Necessário para funções suspend
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")

    // Log para ajudar a debugar (opcional mas recomendado)
    implementation("ch.qos.logback:logback-classic:1.4.11")

    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.13.8") // Para simular a API
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0") // Para testar funções suspend
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}