// Remove the incorrect import and val declarations that were at the top

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.findprime"
    // Corrected: Use a stable SDK version like 34
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.findprime"
        minSdkVersion(26)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0"
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
        // Corrected: For Java 11, use VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    // buildFeatures are often needed for View Binding or Data Binding
    // It's good practice to have this block.
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Correct way to add a dependency not in the version catalog
    implementation("androidx.cardview:cardview:1.0.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // The line `implementation(libs.cardview)` was removed because it's not defined
    // in your libs catalog. The line above this comment correctly adds it.
}
