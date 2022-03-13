package mening.dasturim.babycare.main.ui.main.user.week

import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.FragmentMonthBinding
import mening.dasturim.babycare.databinding.FragmentWeekBinding
import mening.dasturim.babycare.main.ui.base.BasicFragment
import mening.dasturim.babycare.main.ui.main.user.HomeFragmentVM

class WeekFragment : BasicFragment<FragmentWeekBinding, HomeFragmentVM>() {
    private lateinit var vp: WeekVPFragment
    // private lateinit var firebaseFirestore: FirebaseFirestore
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        //      ViewUtils.fadeIn(binding.progressBar)
        vp= WeekVPFragment(requireFragmentManager(),requireActivity().lifecycle)
        // firebaseFirestore = FirebaseFirestore.getInstance()
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("1"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("4"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("8"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("12"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("16"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("20"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("24"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("28"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("32"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("36"))
        val list= listOf<String>("hafta","oy","yil","4","5","6","7","8","9","10")
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

    override fun getLayoutResId()=R.layout.fragment_week
    override val vm: HomeFragmentVM
        get() = ViewModelProvider(this).get(HomeFragmentVM::class.java)
}