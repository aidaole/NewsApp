object BuildVersion {
    const val compileSdk = 30
    const val buildToolsVersion = "30.0.3"
    const val minSdk = 21
    const val targetSdk = 30
}

object AppConfig {
    const val appId = "com.demo.newsapp"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Libs {
    // 依赖库
    const val coreKotlin = "androidx.core:core-ktx:1.5.0"
    const val appcompat = "androidx.appcompat:appcompat:1.3.0"
    const val material = "com.google.android.material:material:1.3.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"

    // 测试依赖
    const val junit = "junit:junit:4.13.2"
    const val testExtJunit = "androidx.test.ext:junit:1.1.2"
    const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
}
