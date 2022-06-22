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
    implementation(Dependencies.FirebaseBom)
    testRuntimeOnly(Dependencies.Test.JunitEngine)
    testImplementation(Dependencies.Test.JunitApi)
    testImplementation(Dependencies.Test.Coroutine)
    testImplementation(Dependencies.Test.Mockk)
    testImplementation(Dependencies.Test.MockkWebServer)
    Dependencies.Debug.forEach(::debugImplementation)
    Dependencies.Compiler.forEach(::kapt)

}