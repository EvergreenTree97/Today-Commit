object Dependencies {
    const val FirebaseBom = "com.google.firebase:firebase-bom:${Versions.FirebaseBom}"
    val Essential = listOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"
    )
    val Ktx = listOf(
        "androidx.core:core-ktx:${Versions.Ktx.Core}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Ktx.LifeCycle}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Ktx.ViewModel}",
    )

    val Ui = listOf(
        "androidx.core:core-splashscreen:${Versions.Ui.Splash}",
    )

    val Jetpack = listOf(
        "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}",
    )

    val Compose = listOf(
        "androidx.compose.material3:material3:${Versions.Compose.Material3}",
        "androidx.activity:activity-compose:${Versions.Compose.Activity}",
        "com.google.accompanist:accompanist-placeholder:${Versions.Compose.Accompanist}",
        "com.google.accompanist:accompanist-swiperefresh:${Versions.Compose.Accompanist}",
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.LifecycleViewModel}",
        "com.google.accompanist:accompanist-navigation-animation:${Versions.Compose.Accompanist}",
        "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.ConstraintLayout}",
        "androidx.compose.ui:ui-tooling:${Versions.Compose.Main}",
        "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.Main}"
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
    }
}