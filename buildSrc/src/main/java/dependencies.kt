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

    const val retrofit_version = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:$retrofit_version"
    const val okhttp_log = "com.squareup.okhttp3:logging-interceptor:4.9.0"

    const val okhttp = "com.squareup.okhttp3:okhttp:3.14.9"
    const val okio = "com.squareup.okio:okio:1.17.2"

    const val gson = "com.google.code.gson:gson:2.8.6"

    const val glide_version = "4.11.0"
    const val glide = "com.github.bumptech.glide:glide:$glide_version"
    const val glide_compiler = "com.github.bumptech.glide:compiler:$glide_version"
//    const val android_arch_life_compiler = "android.arch.lifecycle:compiler:1.0.0"

    // 测试依赖
    const val junit = "junit:junit:4.13.2"
    const val test_ext_junit = "androidx.test.ext:junit:1.1.2"
    const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    const val room_test = "androidx.room:room-testing:$room_version"
}
