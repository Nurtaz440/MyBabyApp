package mening.dasturim.babycare.main.ui.main.user

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.babycare.main.ui.main.user.month.MonthFragment
import mening.dasturim.babycare.main.ui.main.user.week.WeekFragment
import mening.dasturim.babycare.main.ui.main.user.year.YearFragment

class HomeVP (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return WeekFragment()
            1-> return MonthFragment()
            2-> return YearFragment()

        }
        return fragment
    }
}