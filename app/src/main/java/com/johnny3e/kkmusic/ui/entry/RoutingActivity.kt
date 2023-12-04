package com.johnny3e.kkmusic.ui.entry

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.johnny3e.kkmusic.model.ui.LoginStatus
import com.johnny3e.kkmusic.ui.LoginActivity
import com.johnny3e.kkmusic.ui.MainActivity
import com.johnny3e.kkmusic.utils.ext.viewModelFactory
import kotlinx.coroutines.launch

class RoutingActivity : AppCompatActivity() {

    private val viewModel by viewModels<RoutingViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loginFlow.collect { status ->
                    when (status) {
                        LoginStatus.LogOut -> LoginActivity.start(this@RoutingActivity)
                        LoginStatus.LogIn -> MainActivity.start(this@RoutingActivity)
                    }
                    finish()
                }
            }
        }
    }
}