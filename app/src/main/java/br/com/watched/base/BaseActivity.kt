package br.com.watched.base

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import br.com.watched.model.api.ApiResponse
import br.com.watched.model.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_consult.*
import javax.inject.Inject

/**
 * Created by thiagozg on 18/11/2017.
 */
abstract class BaseActivity : AppCompatActivity() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    protected fun observeLoadingStatus(viewModel: BaseViewModel?, resultView: View,
                                       progressView: View) {
        viewModel?.loadingStatus?.observe(this, Observer<Boolean> {
            isLoading -> isLoading?.let {
                resultView.visibility = if (it) GONE else VISIBLE
                progressView.visibility = if (it) VISIBLE else GONE
            }
        })
    }

    protected fun processLoadingStatus() {

    }

    open protected fun processResponse(response: ApiResponse<*>) {
        Log.e(localClassName, "Unknown success json response.")
    }

}