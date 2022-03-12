package mening.dasturim.babycare.main.ui


import android.text.Spanned
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.ActivityMainBinding
import mening.dasturim.babycare.main.ui.base.BaseActivity
import mening.dasturim.babycare.main.ui.main.MainVM

class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onBound() {
       setUp()
    }

    fun setUp(){


        binding.nvBottomBlue.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)

                }
                R.id.statics -> {
                    navController.navigate(R.id.staticsFragment)
                }
                R.id.help -> {
                    navController.navigate(R.id.helpFragment)

                }
                R.id.chat -> {
                    navController.navigate(R.id.chatFragment)

                }
            }
            true
        }
    }

    override fun getLayoutResId() = R.layout.activity_main

    override val vm: MainVM
        get() = ViewModelProvider(this).get(MainVM::class.java)

    override fun showBasicDialog(message: Spanned?, title: String?) {

    }

    override fun onRefreshTokenFail() {

    }

    override fun setStatusBarBackgroundHeight(statusBarBackground: View) {

    }

}