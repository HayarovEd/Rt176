package com.lo.mpm.matchs.oolimob.mobile.sports.omms

import android.app.Application
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.domain.utils.METRICA_RT176
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
        val nextVkr = Random.nextDouble()
        when (nextVkr) {
            1.3-> "s the Kotlin language and ecosystem have continued to evolve, so has the Kotlin compiler. The first s"
            3.5 -> "ext stage of its evolution brings a new frontend known as K2."
        }
    }
}