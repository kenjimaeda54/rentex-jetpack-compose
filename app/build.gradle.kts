plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.rentx"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.rentx"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }

    sourceSets {
        getByName("androidTest"){
            assets.srcDirs(File(projectDir, "schemas"))
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //calendar
    implementation ("io.github.boguszpawlowski.composecalendar:composecalendar:1.1.1")
    implementation ("io.github.boguszpawlowski.composecalendar:kotlinx-datetime:1.1.1")


    //COIL
    implementation("io.coil-kt:coil-compose:2.5.0")

    //GSON
    implementation ("com.google.code.gson:gson:2.9.0")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.5")

    //Cortines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    //hilt navigation
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //Room
    val roomVersion = "2.6.0"
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    //Cortines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // To use Kotlin annottaiton processing toll (Kapt)
    kapt("androidx.room:room-compiler:$roomVersion")


    //Rom with coroutine
    implementation("androidx.room:room-ktx:$roomVersion")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}