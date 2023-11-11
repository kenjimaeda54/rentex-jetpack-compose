package com.example.rentx.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rentx.model.AccessoriesModel
import com.example.rentx.model.CarsModel
import com.example.rentx.model.RentModel
import com.example.rentx.utils.ArrayListConverter



//para automigration funcionar primerio preciso colocar isso no build.gradle
//entao depois posso atualizar a versao para a proxima
//android {
//defaultConfig {
//   kapt {
//        arguments {
//            arg("room.schemaLocation", "$projectDir/schemas")
//        }
//    }
//}
//
//sourceSets {
//    getByName("androidTest") {
//        assets.srcDirs(files(projectDir, "schemas"))
//    }
//}
//
//dependencies {
//   implementation 'androidx.room:room-runtime:2.2.3'
//   kapt 'androidx.room:room-compiler:2.2.3'
//   annotationProcessor 'androidx.room:room-compiler:2.2.3'
//   implementation 'androidx.room:room-rxjava2:2.2.3'
//   androidTestImplementation 'androidx.room:room-testing:2.2.3'
//}
//auto migration quando troco a versao do database e preciso manter os dados anteriores
@Database(
    entities = [CarsModel::class,RentModel::class],
    version = 11,
    autoMigrations = [
        AutoMigration(
            from = 10,
            to = 11,
         )
    ]
)
@TypeConverters(ArrayListConverter::class)
abstract class RentexDatabase : RoomDatabase() {
    abstract fun RentexDao(): RentexDao
}