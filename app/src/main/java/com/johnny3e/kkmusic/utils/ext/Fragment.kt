package com.johnny3e.kkmusic.utils.ext

import androidx.fragment.app.Fragment
import com.johnny3e.kkmusic.App

val Fragment.viewModelFactory get() = App.appContainer.viewModelFactory


