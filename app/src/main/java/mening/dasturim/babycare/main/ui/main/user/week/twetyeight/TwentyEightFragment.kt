package mening.dasturim.babycare.main.ui.main.user.week.twetyeight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.FragmentTwentyBinding
import mening.dasturim.babycare.databinding.FragmentTwentyEightBinding
import mening.dasturim.babycare.main.ui.base.BasicFragment
import mening.dasturim.babycare.main.ui.main.user.week.one.OneFragmentVM

class TwentyEightFragment  : BasicFragment<FragmentTwentyEightBinding, OneFragmentVM>()  {
    override fun onBound() {
        setUp()
    }

    fun setUp(){
        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.sixtennDetailsFragment)
        }
    }
    override fun getLayoutResId()=R.layout.fragment_twenty_eight

    override val vm: OneFragmentVM
        get() = ViewModelProvider(this).get(OneFragmentVM::class.java)

}