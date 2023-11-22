# Rentex
Aplicativo de aluguel de carro, consegue visualizar carros,   é datas disponíveis para aluguel. Possui também descrição de cada carro e seus respectivos carros agendados

## Feature
- No início o pensamento foi salvar os dados no Room, depois foi implementado via backend
- Para salvar uma tabela Room em outra usamos o Embeded , também possui outras [relações](https://medium.com/androiddevelopers/database-relations-with-room-544ab95e4542)_
- Para salvar uma data class pode [converter](console.firebase.google.com/project/company-travel/authentication/providers?hl=pt-br) em json

```kotlin
@Entity(tableName = "cars")
data class CarsModel(
    @PrimaryKey
    val carId: UUID = UUID.randomUUID(),
    val brand: String,
    val name: String,
    val about: String,
    @Embedded val rentModel: RentModel, //RentModel era uma entidade do Room
    @ColumnInfo(name = "fuel_type") val fuelType: String,
    val thumbnail: String,
    val accessoriesJson: ArrayList<AccessoriesModel>,
    val photos: ArrayList<String> //maneria de salvar um json dentro do room
)

// precisa usar o converter e nao pode criar genericos

class ArrayListConverter {


    @TypeConverter
    fun fromAccessoriesArrayList(value: ArrayList<AccessoriesModel>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toAccessoriesArrayList(value: String): ArrayList<AccessoriesModel> {
        return try {
            Gson().fromJson<ArrayList<AccessoriesModel>>(value)
        } catch (e: Exception) {
            arrayListOf()
        }
    }

    @TypeConverter
    fun fromStringArrayList(value: ArrayList<String>): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun toStringArrayList(value: String): ArrayList<String> {
        return try {
            Gson().fromJson<ArrayList<String>>(value)
        } catch (e: Exception) {
            arrayListOf()
        }
    }
}


// depois e so usar
        photos = arrayListOf(
            "https://storage.googleapis.com/golden-wind/ignite/react-native/images/15.png",
            "https://storage.googleapis.com/golden-wind/ignite/react-native/images/16.png",
            "https://storage.googleapis.com/golden-wind/ignite/react-native/images/17.png"

        )

```
##

- Alguns hacker que ajuda construir app

```kotlin

//para trabalhar com dots
@Composable
fun Dots(colorApp: Color,modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(6.dp)) {
        drawCircle(
            color = colorApp
        )
    }
}

// trabalhar com moeda
val localBrazil = Locale("pt", "BR")
val numberFormat = NumberFormat.getCurrencyInstance(localBrazil)
val currency = numberFormat.format(totalPrice)

//trabalhar com data
val formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy")
val formatString = formatDateTime.format(date)

//multiplicar valores quando e opcional ideal e usar times
parentCarViewModel.selectedCar.value?.rent?.price?.times(
        parentScheduleViewModel.selectionDates.value.size
    )

```




  
