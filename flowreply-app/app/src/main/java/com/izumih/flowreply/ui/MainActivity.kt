package com.izumih.flowreply.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.izumih.flowreply.FlowReplyApplication
import com.izumih.flowreply.ui.screens.ConfigScreen
import com.izumih.flowreply.ui.screens.OnboardingScreen
import com.izumih.flowreply.ui.screens.SplashScreen
import com.izumih.flowreply.ui.theme.FlowReplyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            FlowReplyTheme {
                FlowReplyApp()
            }
        }
    }
}

object Routes {
    const val SPLASH = "splash"
    const val ONBOARDING = "onboarding"
    const val CONFIG = "config"
}

@Composable
fun FlowReplyApp() {
    val navController = rememberNavController()
    val app = FlowReplyApplication.instance

    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            val onboardingDone by produceState<Boolean?>(initialValue = null) {
                value = app.preferencesManager.isOnboardingCompleted()
            }
            SplashScreen(
                ready = onboardingDone != null,
                onReady = {
                    val next = if (onboardingDone == true) Routes.CONFIG else Routes.ONBOARDING
                    navController.navigate(next) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                },
            )
        }
        composable(Routes.ONBOARDING) {
            OnboardingScreen(
                onFinished = {
                    navController.navigate(Routes.CONFIG) {
                        popUpTo(Routes.ONBOARDING) { inclusive = true }
                    }
                },
            )
        }
        composable(Routes.CONFIG) {
            val vm: ConfigViewModel = viewModel(
                factory = ConfigViewModel.Factory(app.preferencesManager),
            )
            ConfigScreen(viewModel = vm)
        }
    }
}
