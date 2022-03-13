package mening.dasturim.babycare.main.ui.main.user.week.twenty

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.FragmentSizteenBinding
import mening.dasturim.babycare.databinding.FragmentTwentyBinding
import mening.dasturim.babycare.main.ui.base.BasicFragment
import mening.dasturim.babycare.main.ui.main.user.week.one.OneFragmentVM

class TwentyFragment : BasicFragment<FragmentTwentyBinding, OneFragmentVM>()  {
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.sixtennDetailsFragment)
        }
    }
    override fun getLayoutResId()=R.layout.fragment_twenty

    override val vm: OneFragmentVM
        get() = ViewModelProvider(this).get(OneFragmentVM::class.java)

}