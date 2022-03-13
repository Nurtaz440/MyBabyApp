package mening.dasturim.babycare.main.ui.main.user.week.thirtysix

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.FragmentThirtySixBinding
import mening.dasturim.babycare.main.ui.base.BasicFragment
import mening.dasturim.babycare.main.ui.main.user.week.one.OneFragmentVM

class ThirtySixFragment : BasicFragment<FragmentThirtySixBinding, OneFragmentVM>()  {
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.thirtyTwoDeatilsFragment)
        }
    }
    override fun getLayoutResId()=R.layout.fragment_thirty_six

    override val vm: OneFragmentVM
        get() = ViewModelProvider(this).get(OneFragmentVM::class.java)
}