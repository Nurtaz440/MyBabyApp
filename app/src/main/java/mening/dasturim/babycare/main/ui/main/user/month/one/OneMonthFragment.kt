package mening.dasturim.babycare.main.ui.main.user.month.one

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.FragmentOneMonthBinding
import mening.dasturim.babycare.main.ui.base.BasicFragment
import mening.dasturim.babycare.main.ui.main.user.week.one.OneFragmentVM

class OneMonthFragment: BasicFragment<FragmentOneMonthBinding, OneFragmentVM>()  {
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.oneMonthDetailsFragment)
        }
    }
    override fun getLayoutResId()=R.layout.fragment_one_month

    override val vm: OneFragmentVM
        get() = ViewModelProvider(this).get(OneFragmentVM::class.java)
}