plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.mvvm_dagger2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mvvm_dagger2"
        minSdk = 24
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

        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

dependencies {
    // Dagger2
    implementation ("com.google.dagger:dagger:2.52")
    kapt ("com.google.dagger:dagger-compiler:2.52")

    //room
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // viewmodel and lifecyle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")

    // retrofit and gson converter
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")


    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}