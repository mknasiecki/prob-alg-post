plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    //HLL implementation
    implementation("org.apache.datasketches:datasketches-java:3.3.0")

    //Bloom Filter implementation
    implementation("com.google.guava:guava:30.1.1-jre")
}
