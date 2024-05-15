package com.edurda77.rt176

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.edurda77.rt176.ui.state.MainViewModelRt176
import com.edurda77.rt176.ui.theme.Rt176Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent {
            Rt176Theme {
                //val sport = Sport.entries.toTypedArray().random()
                val viewModel: MainViewModelRt176 = hiltViewModel()
                val state = viewModel.state.collectAsState()
            }
        }
    }
}
