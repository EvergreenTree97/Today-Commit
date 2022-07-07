import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("com.google.android.gms.oss-licenses-plugin")
    id("name.remal.check-dependency-updates") version Versions.Util.CheckDependencyUpdates
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("de.mannodermaus.android-junit5")
}
android {
    compileSdk = Application.compileSdk
    namespace = "com.evergreen.todaycommit"
    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
        buildConfigField("String","GITHUB_TOKEN", getApiKey("GITHUB_TOKEN"))
    }

    buildTypes {
        release {

            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }
    compileOptions {
        sourceCompatibility = Application.sourceCompat
        targetCompatibility = Application.targetCompat
    }
    kotlinOptions {
        jvmTarget = Application.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Main
    }
}

dependencies {
    Dependencies.Essential.forEach(::implementation)
    Dependencies.Ui.forEach(::implementation)
    Dependencies.Ktx.forEach(::implementation)
    Dependencies.Compose.forEach(::implementation)
    Dependencies.Network.forEach(::implementation)
    Dependencies.Jetpack.forEach(::implementation)
    Dependencies.Jackson.forEach(::implementation)
    Dependencies.Util.forEach(::implementation)
    Dependencies.Firebase.forEach(::implementation)
    implementation(platform(Dependencies.FirebaseBom))
    testRuntimeOnly(Dependencies.Test.JunitEngine)
    testImplementation(Dependencies.Test.JunitApi)
    testImplementation(Dependencies.Test.Coroutine)
    testImplementation(Dependencies.Test.Mockk)
    Dependencies.Debug.forEach(::debugImplementation)
    Dependencies.Compiler.forEach(::kapt)

}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}