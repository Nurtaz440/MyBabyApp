package mening.dasturim.babycare.main.ui.main.user


import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.FragmentHomeBinding
import mening.dasturim.babycare.main.ui.base.BasicFragment

class HomeFragment : BasicFragment<FragmentHomeBinding,HomeFragmentVM>() {
    private lateinit var vp:HomeVP
   // private lateinit var firebaseFirestore: FirebaseFirestore
    override fun onBound() {
        setUp()
    }

    fun setUp(){
  //      ViewUtils.fadeIn(binding.progressBar)
        vp= HomeVP(requireFragmentManager(),requireActivity().lifecycle)
       // firebaseFirestore = FirebaseFirestore.getInstance()
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Haftalik"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Oylik"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Yillik"))
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

    override fun getLayoutResId()=R.layout.fragment_home
    override val vm: HomeFragmentVM
        get() =ViewModelProvider(this).get(HomeFragmentVM::class.java)


}