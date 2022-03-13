package mening.dasturim.babycare.main.ui.main.user.week.one

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.FragmentOneBinding
import mening.dasturim.babycare.main.ui.base.BasicFragment

class OneFragment : BasicFragment<FragmentOneBinding, OneFragmentVM>()  {
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.oneWeekDetailsFragment)
        }
    }
    override fun getLayoutResId()=R.layout.fragment_one

    override val vm: OneFragmentVM
        get() = ViewModelProvider(this).get(OneFragmentVM::class.java)

}