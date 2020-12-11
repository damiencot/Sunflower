package fr.nansty.sunflower.data

class DepotPlante private constructor(private val planteDao: PlanteDao) {

    fun obtenirDesPlantes() = planteDao.obtenirDePlantes()

    fun obtenirUnePlante(idPLante:String) = planteDao.obtenirUnePlante(idPLante)

    fun obtenirDesPlantesAvecNumDeCroissance(numZoneDeCroissance: Int) =
        planteDao.obtenirDesPlantesAvecNumDeCroissance(numZoneDeCroissance)

    companion object {
        //Pour un seul enregistrement
        @Volatile private var instance: DepotPlante? = null

        //Pour les enregistrements multiples
        fun obtenirUneInstance(planteDao: PlanteDao) =
            instance ?: synchronized(this){
                instance ?: DepotPlante(planteDao).also { instance = it }
            }
    }
}