package mening.dasturim.babycare.main.ui.main.user.year

import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.FragmentYearBinding
import mening.dasturim.babycare.main.ui.base.BasicFragment
import mening.dasturim.babycare.main.ui.main.user.HomeFragmentVM

class YearFragment : BasicFragment<FragmentYearBinding, HomeFragmentVM>() {
    private lateinit var vp: YearsFragmentVP
    // private lateinit var firebaseFirestore: FirebaseFirestore
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        //      ViewUtils.fadeIn(binding.progressBar)
        vp= YearsFragmentVP(requireFragmentManager(),requireActivity().lifecycle)
        // firebaseFirestore = FirebaseFirestore.getInstance()
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("1"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("2"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("3"))

        val list= listOf<String>("hafta","oy","yil")
        vp.setData(list)

        binding.viewPager.adapter=vp
        binding.viewPager.offscreenPageLimit=1

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem=tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })

    }

    override fun getLayoutResId()=R.layout.fragment_year
    override val vm: HomeFragmentVM
        get() = ViewModelProvider(this).get(HomeFragmentVM::class.java)
}