package mening.dasturim.babycare.main.ui


import android.text.Spanned
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.google.android.material.bottomnavigation.BottomNavigationView
import mening.dasturim.babycare.R
import mening.dasturim.babycare.databinding.ActivityMainBinding
import mening.dasturim.babycare.main.ui.base.BaseActivity
import mening.dasturim.babycare.main.ui.main.MainVM
import mening.dasturim.babycare.main.utils.ViewUtils

class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onBound() {
       setUp()
    }

    fun setUp(){

        val navHost = supportFragmentManager.findFragmentById(R.id.partial_nav_controller)
        if (navHost != null) {
            navController = navHost.findNavController()
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment ||
                destination.id == R.id.staticsFragment ||
                destination.id == R.id.helpFragment ||
                destination.id == R.id.chatFragment

            ) {
                ViewUtils.fadeIn(binding.nvBottomBlue)
            } else {
                ViewUtils.fadeOut(binding.nvBottomBlue)
            }
        }

        binding.nvBottomBlue.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> {
                        Log.d("tag","home"+item.toString())
                        navController.navigate(R.id.homeFragment)

                    }
                    R.id.statics -> {
                        navController.navigate(R.id.staticsFragment)
                        Log.d("tag","statics"+item.toString())

                    }
                    R.id.help -> {
                        navController.navigate(R.id.helpFragment)
                        Log.d("tag",item.toString())


                    }
                    R.id.chat -> {
                        navController.navigate(R.id.chatFragment)
                        Log.d("tag",item.toString())


                    }
                }
              return  true
            }

        })

      //  binding.ivBackArrow.setOnClickListener { onBackPressed() }
    }

    override fun getLayoutResId() = R.layout.activity_main

    override val vm: MainVM
        get() = ViewModelProvider(this).get(MainVM::class.java)

    override fun setStatusBarBackgroundHeight(statusBarBackground: View) {

    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }

    override fun onRefreshTokenFail() {
    }

    override fun showBasicDialog(message: Spanned?, title: String?) {

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}