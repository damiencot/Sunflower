package fr.nansty.sunflower.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import fr.nansty.sunflower.JardinFragment
import fr.nansty.sunflower.ListDesPlantesFragment
import java.lang.IndexOutOfBoundsException


const val INDEX_PAGE_DE_MON_JARDIN = 0
const val INDEX_PAGE_LISTE_DES_PLANTES = 1

class SunflowerPagerAdapter(fragment:Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators : Map<Int, () -> Fragment> = mapOf(
        INDEX_PAGE_DE_MON_JARDIN to { JardinFragment() },
        INDEX_PAGE_LISTE_DES_PLANTES to { ListDesPlantesFragment() }
    )

    override fun getItemCount(): Int {
        return tabFragmentsCreators.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw  IndexOutOfBoundsException()
    }
}