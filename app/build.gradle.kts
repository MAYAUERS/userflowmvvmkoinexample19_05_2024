plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.userflowmvvmkoinexample19_05_2024"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.userflowmvvmkoinexample19_05_2024"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutines for asynchronous programming
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")

    // ViewModel and LiveData for MVVM architecture
    implementation ("androidx.lifecycle:lifecycle-livedata:2.7.0")
    //koin
    implementation ("io.insert-koin:koin-androidx-compose:3.2.0")

    //coil
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")

    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
}
