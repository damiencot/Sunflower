package fr.nansty.sunflower.data

class DepotJardinDePlante(
    private val jardinDePlanteDao: JardinDePlanteDao
) {
    suspend fun creationDeJardinDePlante(idPlante: String){
        val jardinDePlante = JardinDePlante(idPlante)
        jardinDePlanteDao.ajouterUnePLanteAuJardin(jardinDePlante)
    }

    suspend fun retirerLaPlanteAuJardin(jardinDePlante: JardinDePlante){
        jardinDePlanteDao.supprimerUnePlanteAuJardin(jardinDePlante)
    }

    fun estPlantee(idPlante: String) =
        jardinDePlanteDao.estPlante(idPlante)

    fun obtenirJardinPlante() = jardinDePlanteDao.obtenirJardinPLantE()

    companion object {

        //Pour une seule instantiation
        @Volatile private var instance: DepotJardinDePlante? = null

        fun obtenirUneInstance(jardinDePlanteDao: JardinDePlanteDao) =
            instance ?: synchronized(this){
                instance ?: DepotJardinDePlante(jardinDePlanteDao).also { instance = it }
            }
    }
}