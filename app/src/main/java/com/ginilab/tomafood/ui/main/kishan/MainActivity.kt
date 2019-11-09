package com.ginilab.tomafood.ui.main.kishan

import android.os.Bundle
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.core.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override fun getLayoutRes()= R.layout.main_activity

    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    MainFragment.newInstance()
                )
                .commitNow()
        }
    }

}
