package mening.dasturim.babycare.main.ui.main.user.month

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.babycare.main.ui.main.user.month.eight.EightMonthFragment
import mening.dasturim.babycare.main.ui.main.user.month.four.FourMonthFragment
import mening.dasturim.babycare.main.ui.main.user.month.one.OneMonthFragment
import mening.dasturim.babycare.main.ui.main.user.month.ten.TenMonthFragment
import mening.dasturim.babycare.main.ui.main.user.week.two.TwoFragment
import mening.dasturim.babycare.main.ui.main.user.year.YearFragment

class MonthFragmentVP (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager,lifecycle) {
    var list = listOf<String>()

    fun setData(itemList: List<String>){
        this.list=itemList
        notifyDataSetChanged()
    }
    override fun getItemCount()=list.size

    override fun createFragment(position: Int): Fragment {
        val fragment= Fragment()
        when(position){
            0-> return OneMonthFragment()
            1-> return FourMonthFragment()
            2-> return EightMonthFragment()
            3-> return TenMonthFragment()

        }
        return fragment
    }
}