package fr.nansty.sunflower.data

import androidx.room.Embedded
import androidx.room.Relation

class PlanteEtJardinDesPlantes (
    @Embedded
    val plante: Plante,
    @Relation(parentColumn = "id", entityColumn = "id_plante")
    val jardinDesPlantes: List<JardinDePlante> = emptyList()
)