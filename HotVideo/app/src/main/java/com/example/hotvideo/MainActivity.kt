package com.example.hotvideo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.hotvideo.domain.usecases.AppEntryUseCases
import com.example.hotvideo.presentation.screen.onboarding.OnBoardScreen
import com.example.hotvideo.ui.theme.HotVideoTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect {
                Log.d("test", it.toString())
            }
        }
        enableEdgeToEdge()
        setContent {
            HotVideoTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    OnBoardScreen()
                }
            }
        }
    }
}

