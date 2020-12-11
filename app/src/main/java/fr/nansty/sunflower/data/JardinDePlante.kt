package fr.nansty.sunflower.data

import androidx.room.*
import java.util.*

@Entity(
    tableName = "jardinDesPlantes",
    foreignKeys = [
        ForeignKey(entity = Plante::class, parentColumns = ["id"], childColumns = ["id_plante"] )
    ],
    indices =  [Index("id_plante")]
)
data class JardinDePlante (

    @ColumnInfo(name = "id_plante") val idPlante: String,

    /*Indique quand la plante a été plantée
    * * Utilisé pour notifier lorsqu'il est temps de recolter la plante
    * * */
    @ColumnInfo(name = "date_plante") val datePlante: Calendar = Calendar.getInstance(),

    @ColumnInfo(name = "derniere_date_darrosage")
    val derniereDateDarrosage: Calendar = Calendar.getInstance()
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var idJardinDePlante : Long = 0
}