package com.example.rentx.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.UUID
import kotlin.collections.ArrayList

//com embedded consigo inserir minhas classes como a RentModel, listas seria ideal converter
@Entity(tableName = "cars")
data class CarsModel(
    @PrimaryKey
    val carId: UUID = UUID.randomUUID(),
    val brand: String,
    val name: String,
    val about: String,
    @Embedded val rentModel: RentModel,
    @ColumnInfo(name = "fuel_type") val fuelType: String,
    val thumbnail: String,
    //REFERNCIA de relacoes https://medium.com/androiddevelopers/database-relations-with-room-544ab95e4542
    val accessoriesJson: ArrayList<AccessoriesModel>,
    val photos: ArrayList<String> //maneria de salvar um json dentro do room
    //room nao aceita lsitas entao estou convertendo string e a classe AcessoriesModel
    //referencia https://ngima.medium.com/how-to-save-list-of-data-in-table-column-in-room-using-type-converter-gson-691aa780ab19
)
