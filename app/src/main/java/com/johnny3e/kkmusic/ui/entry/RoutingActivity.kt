package com.johnny3e.kkmusic.ui.entry

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.johnny3e.kkmusic.ui.LoginActivity
import com.johnny3e.kkmusic.utils.ext.viewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RoutingActivity : AppCompatActivity() {

    private val viewModel by viewModels<RoutingViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            delay(500)
            LoginActivity.start(this@RoutingActivity)
            finish()
        }

    }
}