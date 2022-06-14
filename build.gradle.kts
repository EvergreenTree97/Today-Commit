buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.Essential.Gradle}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.Jetpack.Hilt}")
        classpath("com.google.gms:google-services:${Versions.Essential.GoogleService}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Essential.Kotlin}")
        classpath("com.google.android.gms:oss-licenses-plugin:${Versions.OssLicense.Classpath}")
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.Util.SecretsGradlePlugin}")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:${Versions.Test.JUnitGradle}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    rootProject.buildDir.delete()
}