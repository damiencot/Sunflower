package fr.nansty.sunflower.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlanteDao {

    @Query("SELECT * FROM plantes ORDER BY nom")
    fun obtenirDePlantes(): LiveData<List<Plante>>

    @Query("SELECT * FROM plantes WHERE numZoneDeCroissance = :numZoneDeCroissance ORDER BY nom")
    fun obtenirDesPlantesAvecNumDeCroissance(numZoneDeCroissance: Int): LiveData<List<Plante>>

    @Query("SELECT * FROM plantes WHERE id = :idPlante")
    fun obtenirUnePlante(idPlante: String): LiveData<Plante>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun toutAjouter(plantes: List<Plante>)

}