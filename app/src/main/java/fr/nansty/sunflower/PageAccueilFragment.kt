package fr.nansty.sunflower

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import fr.nansty.sunflower.databinding.FragmentPageAccueilBinding
import kotlinx.android.synthetic.main.fragment_page_accueil.view.*
import com.google.android.material.tabs.TabLayoutMediator
import fr.nansty.sunflower.adapters.INDEX_PAGE_DE_MON_JARDIN
import fr.nansty.sunflower.adapters.INDEX_PAGE_LISTE_DES_PLANTES
import fr.nansty.sunflower.adapters.SunflowerPagerAdapter
import java.lang.IndexOutOfBoundsException


class PageAccueilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_page_accueil, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.view_pager

        viewPager.adapter = SunflowerPagerAdapter(this)

        //Liaison d'icone et text pour chaque tab
        TabLayoutMediator(tabLayout, viewPager){
            tab, position -> tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        return binding.rootView
    }

    private fun getTabTitle(position: Int): String? {
        return when(position){
            INDEX_PAGE_DE_MON_JARDIN -> getString(R.string.my_garden_title)
            INDEX_PAGE_LISTE_DES_PLANTES -> getString(R.string.plant_list_title)
            else -> null
        }
    }

    private fun getTabIcon(position: Int): Int {
        return when(position){
            INDEX_PAGE_DE_MON_JARDIN -> R.drawable.garden_tab_selector
            INDEX_PAGE_LISTE_DES_PLANTES -> R.drawable.plant_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

}