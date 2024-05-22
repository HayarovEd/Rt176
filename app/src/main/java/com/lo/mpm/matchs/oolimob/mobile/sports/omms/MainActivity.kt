package com.lo.mpm.matchs.oolimob.mobile.sports.omms

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.ui.BaseSceneRt176
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.ui.state.MainViewModelRt176
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.ui.theme.Rt176Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent {
            Rt176Theme {
                BaseSceneRt176()
            }
        }
    }
}
