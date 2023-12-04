package com.johnny3e.kkmusic.utils.ext

import android.app.Activity
import com.johnny3e.kkmusic.App

val Activity.viewModelFactory get() = App.appContainer.viewModelFactory