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

    const val lifecycle_version = "2.2.0"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"

    const val room_version = "2.3.0"
    const val room = "androidx.room:room-runtime:$room_version"
    const val room_compiler = "androidx.room:room-compiler:$room_version"

    const val nav_version = "2.3.5"
    const val nav_fragment = "androidx.navigation:navigation-fragment-ktx:$nav_version"
    const val nav_ui = "androidx.navigation:navigation-ui-ktx:$nav_version"

    const val hilt_version = "2.28-alpha"
    const val hilt = "com.google.dagger:hilt-android:$hilt_version"
    const val hilt_compiler = "com.google.dagger:hilt-android-compiler:$hilt_version"

    const val coroutinues_version = "1.3.9"
    const val coroutinue = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinues_version"

    // 测试依赖
    const val junit = "junit:junit:4.13.2"
    const val test_ext_junit = "androidx.test.ext:junit:1.1.2"
    const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    const val room_test = "androidx.room:room-testing:$room_version"
}
