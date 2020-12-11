package fr.nansty.sunflower.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

interface JardinDePlanteDao {

    @Query("SELECT * FROM jardinDesPlantes")
    fun obtenirJardinDesPlantes() : LiveData<List<JardinDePlante>>

    @Query("SELECT EXISTS(SELECT 1 FROM jardinDesPlantes WHERE id_plante = :idPlante LIMIT 1)")
    fun estPlante(idPlante: String): LiveData<Boolean>

    /*Cette requete indiquera à Room d'interroger la table [Plante] et [PlantesEnJardin*/
    @Transaction
    @Query("SELECT * FROM plantes WHERE id IN (SELECT DISTINCT(id_plante) FROM jardinDesPlantes)")
    fun obtenirJardinPLantE(): LiveData<List<PlanteEtJardinDesPlantes>>

    @Insert
    suspend fun ajouterUnePLanteAuJardin(jardinDePlante: JardinDePlante) : Long

    @Delete
    suspend fun supprimerUnePlanteAuJardin(jardinDePlante: JardinDePlante)
}