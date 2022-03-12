package mening.dasturim.babycare.main.ui.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Spanned
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.gson.Gson
import mening.dasturim.babycare.R
import mening.dasturim.babycare.main.data.constants.Constants
import mening.dasturim.babycare.main.data.locale.PrefsHelper
import mening.dasturim.babycare.main.data.retrofit.ApiClient
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.util.*

abstract class BaseActivity<T: ViewDataBinding,V:BaseVM>
    :AppCompatActivity(),BaseMethods{
        private val gson:Gson = Gson()
    lateinit var prefs:PrefsHelper

    @LayoutRes
    abstract fun getLayoutResId():Int

    abstract fun onBound()

    protected abstract val vm:V

    protected lateinit var binding :T
    private set

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        updateBaseContextLocale(this)

        binding =DataBindingUtil.setContentView(this,getLayoutResId())
        doDataBinding()

    }
    override fun doDataBinding(){
        binding.lifecycleOwner=this
        binding.setVariable(1,vm)

    }
    override fun setStatusBarColor(color:Int){
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

            window.statusBarColor = ContextCompat.getColor(this,color)

        }

    }
    override fun showDialogNoNetwork(){
        showBasicDialog(getString(R.string.msg_no_network))
    }
    override fun showDialog(message:String,title:String?){
        showBasicDialog((message),title)
    }
    override fun showDialog(message:Int,title:String?){
        showBasicDialog(getString(message),title)
    }
    override fun showDialog(message:Spanned?,title:String?){
        showBasicDialog(message,title)
    }

    override fun showDialogErrorUnknown(){
        showBasicDialog(getString(R.string.msg_uncknown_error))
    }
    private fun updateBaseContextLocale(context:Context):Context{
        val locale=Locale(prefs.language ?: Constants.LANGUAGE_UZBEK)
        Locale.setDefault(locale)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return updateResourcesLocale(context,locale)
        }
        return updateResourceLocalLegacy(context,locale)
    }
    private fun updateResourceLocalLegacy(context: Context,locale: Locale):Context{
        val resources=context.resources
        val conf=resources.configuration
        conf.setLocale(locale)
        resources.updateConfiguration(conf,resources.displayMetrics)
        return context
    }
    override fun showBasicDialog(message:String,title: String?){
        if (!isFinishing.not()){
            MaterialAlertDialogBuilder(this,R.style.ThemeOverlay_App_MaterialAlertDialog)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(R.string.action_ok){
                    dialog,which->

                }.show()

        }
    }
    override fun hideKeyboard(){
        this.currentFocus?.let {
            it.clearFocus()
            val imm: InputMethodManager? =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(it.windowToken,0)

        }
    }
    override fun showKeyboard(view: View){
        val imm : InputMethodManager? = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.showSoftInput(view,0)
    }
    override fun handleError(it:Throwable){
        when(it){
            is ConnectException-> {
                // check if the internet connection at all
                InternetChecker{ hasInternet->
                    // if there is internet ,that means we are not able to connect on thr server
                    if (hasInternet!!){
                        showBasicDialog(getString(R.string.msg_cannot_connect_to_server))

                    }else{
                        //else ,there is not a iternet connection
                        showDialogNoNetwork()
                    }
                }
            }
            is IOException ->showDialogNoNetwork()
            is HttpException -> {

            }
            else -> showDialogErrorUnknown()
        }
    }
    override fun handleError(it:BaseRes){

    }

    override fun setToolbarLimitless(toolbarContainer :View,title:Int){
        setToolbarLimitless(toolbarContainer,getString(title))
    }
    override  fun setToolbarLimitless(toolbarContainer: View,title: String?){

    }
    override fun setLanguage(language:String){
        ApiClient.restartRetrofit()
        Constants.language=language
        prefs.language = language

        val dm = resources.displayMetrics
        val conf = resources.configuration
        val locale= Locale(language)

        conf.setLocale(locale)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            applicationContext.createConfigurationContext(conf)

        }else{
            resources.updateConfiguration(conf,dm)
        }
    }

    override fun attachBaseContext(newBase: Context) {
        prefs= PrefsHelper(gson,PreferenceManager.getDefaultSharedPreferences(newBase))
        super.attachBaseContext(updateBaseContextLocale(newBase))
    }
    private fun updateResourcesLocale(context: Context,locale: Locale):Context{
        val conf=context.resources.configuration
        conf.setLocale(locale)
        return context.createConfigurationContext(conf)
    }
}