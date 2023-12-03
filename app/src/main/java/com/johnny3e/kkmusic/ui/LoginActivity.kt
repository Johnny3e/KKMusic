package com.johnny3e.kkmusic.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.johnny3e.kkmusic.databinding.ActivityLoginBinding
import com.johnny3e.kkmusic.utils.ext.viewModelFactory
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                observerUiState()
            }
        }
    }

    private suspend fun observerUiState() {
        viewModel.uiState.collect {
            if (it.loginSuccess) {
                MainActivity.start(this)
                finish()
            }
        }
    }

    private fun initView() = binding.apply {

        btEnter.setOnClickListener {
            val id = edId.text.toString()
            val secret = edSecret.text.toString()
            viewModel.loginWithClientCredential(id, secret)
        }
    }

    companion object {
        fun start(ctx: Context) {
            ctx.startActivity(Intent(ctx, LoginActivity::class.java))
        }
    }
}