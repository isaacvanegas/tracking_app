plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp") version "1.9.20-1.0.14"
}

android {
    namespace = "ni.com.groupi.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "ni.com.groupi.myapplication"
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
    }
    buildFeatures{
        viewBinding = true   // permite utilizar el viewbinding en toda la aplicacion
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.datastore)

    //implementacion de Room
    implementation(libs.androidx.room.runtime)
    ksp("androidx.room:room-compiler:${rootProject.extra["room_version"]}")
    // utilizada para corrutinas con Room
    implementation(libs.androidx.room.ktx)

    // para integrar la paginacion
    implementation(libs.androidx.room.paging)

    implementation(libs.retrofit)// librerira utilizada para simplificar peticiones a apis
    implementation(libs.okhttp) // agregada libreria OkHttp para petriciones http
    implementation(libs.logging.interceptor) // derivada de OkHttp para depurar peticiones http
    implementation(libs.converter.gson) // derivadad de Retrofit permite convertir datos JSON a objetos Java/Kotlin

    implementation(libs.kotlinx.coroutines.core)//agregar corrutinas
    implementation(libs.kotlinx.coroutines.android)// agregar corrutinas en android

    implementation(libs.mpandroidchart)//Libreria utilizada para graficos

}