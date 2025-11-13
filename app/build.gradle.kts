plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.mykotlinwearos"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mykotlinwearos"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //HEALTH SERVICES
    implementation("androidx.health:health-services-client:1.1.0-alpha05")

    implementation("androidx.navigation:navigation-compose:2.9.5")
    // Compose core
    implementation("androidx.compose.ui:ui:1.7.0")
    implementation("androidx.compose.material:material:1.7.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.0")

    // Navigation
    implementation("androidx.wear.compose:compose-navigation:1.5.0")
    implementation("androidx.navigation:navigation-compose:2.8.0")

    // (Optional but recommended)
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation(libs.play.services.wearable)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.tooling.preview)
    implementation(libs.compose.material)
    implementation(libs.compose.foundation)
    implementation(libs.wear.tooling.preview)
    implementation(libs.activity.compose)
    implementation(libs.core.splashscreen)
    implementation(libs.navigation.runtime.android)
    implementation(libs.foundation.layout.android)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}