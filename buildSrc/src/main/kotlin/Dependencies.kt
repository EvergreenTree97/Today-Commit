object Dependencies {
    const val FirebaseBom = "com.google.firebase:firebase-bom:${Versions.FirebaseBom}"
    val Essential = listOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"
    )

    val Firebase = listOf(
         "com.google.firebase:firebase-messaging",
         "com.google.firebase:firebase-analytics",
    )
    val Ktx = listOf(
        "androidx.core:core-ktx:${Versions.Ktx.Core}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Ktx.LifeCycle}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Ktx.ViewModel}",
    )

    val Ui = listOf(
        "androidx.core:core-splashscreen:${Versions.Ui.Splash}",
    )

    val Util = listOf(
        "com.jakewharton.threetenabp:threetenabp:${Versions.Util.ThreeTen}"
    )

    val Jetpack = listOf(
        "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}",
    )

    val Network = listOf(
        "com.squareup.retrofit2:retrofit:${Versions.Network.Retrofit}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OkHttp}",
        "com.squareup.okhttp3:okhttp:${Versions.Network.OkHttp}",
        "com.squareup.retrofit2:converter-jackson:${Versions.Network.Retrofit}"
    )

    val Jackson = listOf(
        "com.fasterxml.jackson.core:jackson-core:${Versions.Util.Jackson}",
        "com.fasterxml.jackson.core:jackson-databind:${Versions.Util.Jackson}",
        "com.fasterxml.jackson.core:jackson-annotations:${Versions.Util.Jackson}",
        "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.Util.Jackson}"
    )

    val Compose = listOf(
        "androidx.compose.material3:material3:${Versions.Compose.Material3}",
        "androidx.activity:activity-compose:${Versions.Compose.Activity}",
        "com.google.accompanist:accompanist-placeholder:${Versions.Compose.Accompanist}",
        "com.google.accompanist:accompanist-swiperefresh:${Versions.Compose.Accompanist}",
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.Compose.Accompanist}",
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.LifecycleViewModel}",
        "com.google.accompanist:accompanist-navigation-animation:${Versions.Compose.Accompanist}",
        "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.ConstraintLayout}",
        "androidx.hilt:hilt-navigation-compose:${Versions.Compose.HiltNavigationCompose}",
        "androidx.compose.ui:ui-tooling:${Versions.Compose.Main}",
        "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.Main}",
        "io.coil-kt:coil-compose:${Versions.Compose.Coil}"
    )

    val Compiler = listOf(
        "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}",
    )

    val Debug = listOf(
        "com.squareup.leakcanary:leakcanary-android:${Versions.Util.LeakCanary}"
    )

    object Test {
        const val JunitApi = "org.junit.jupiter:junit-jupiter-api:${Versions.Test.JUnit}"
        const val JunitEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.Test.JUnit}"
        const val Coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.Coroutine}"
        const val Mockk = "io.mockk:mockk:${Versions.Test.Mockk}"
    }
}