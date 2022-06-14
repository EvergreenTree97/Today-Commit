import org.gradle.api.JavaVersion

object Application {
    const val minSdk = 21
    const val targetSdk = 32
    const val compileSdk = 32
    const val jvmTarget = "11"
    const val versionCode = 1
    const val versionName = "1.0.0"

    val targetCompat = JavaVersion.VERSION_11
    val sourceCompat = JavaVersion.VERSION_11
}