package fr.nansty.sunflower.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "plantes")
data class Plante (
    @PrimaryKey @ColumnInfo(name = "id") val idPlante: String,
    val nom : String,
    val description : String,
    val numZoneDeCroissance : Int,
    val intervalDarrosage : Int = 7,
    val urlImg : String = ""

){
    fun doitEtreArrosee(depuis: Calendar, derniereDateDarrosage: Calendar) =
        depuis > derniereDateDarrosage.apply { add(Calendar.DAY_OF_YEAR, intervalDarrosage) }

    override fun toString() = nom
}