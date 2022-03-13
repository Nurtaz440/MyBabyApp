package mening.dasturim.babycare.main.ui.main.user.year

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mening.dasturim.babycare.main.ui.main.user.week.eight.EightWeekFragment
import mening.dasturim.babycare.main.ui.main.user.week.one.OneFragment
import mening.dasturim.babycare.main.ui.main.user.week.sixteen.SizteenFragment
import mening.dasturim.babycare.main.ui.main.user.week.thirtysix.ThirtySixFragment
import mening.dasturim.babycare.main.ui.main.user.week.thretytwo.ThityTwoFragment
import mening.dasturim.babycare.main.ui.main.user.week.twelve.TwelveFragment
import mening.dasturim.babycare.main.ui.main.user.week.twenty.TwentyFragment
import mening.dasturim.babycare.main.ui.main.user.week.twentyfour.TwentyFourFragment
import mening.dasturim.babycare.main.ui.main.user.week.twetyeight.TwentyEightFragment
import mening.dasturim.babycare.main.ui.main.user.week.two.TwoFragment
import mening.dasturim.babycare.main.ui.main.user.year.one.OneYearFragment
import mening.dasturim.babycare.main.ui.main.user.year.three.ThreeYearsFragment
import mening.dasturim.babycare.main.ui.main.user.year.two.TwoYearFragment

class YearsFragmentVP(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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
            0-> return OneYearFragment()
            1-> return TwoYearFragment()
            2-> return ThreeYearsFragment()

        }
        return fragment
    }
}