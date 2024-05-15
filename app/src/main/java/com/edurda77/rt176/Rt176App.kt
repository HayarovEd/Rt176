package com.edurda77.rt176

import android.app.Application
import com.edurda77.rt176.domain.utils.METRICA_RT176
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp
import kotlin.random.Random

@HiltAndroidApp
class Rt176App:Application() {
    override fun onCreate() {
        super.onCreate()
        val config = YandexMetricaConfig.newConfigBuilder(METRICA_RT176).build()
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        val fg = Random.nextDouble(0.0, 207.0)
        val vbn = 8
        val sd = if (fg>vbn) fg else vbn
        println(sd)
    }
}