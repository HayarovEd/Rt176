package com.edurda77.rt176.ui.state

import java.time.LocalDate

sealed class ApplicationEventRt176 {
    class OnSetApplicationStateRt176(val applicationStRt176: ApplicationStRt176, gnnn: Double = 67.5555) : ApplicationEventRt176()
    class OnSetSelectedDateRt176(val selectedDate: LocalDate, val dfdsss: Double = 56.5) : ApplicationEventRt176()
    class OnUpdateProfileRt176(val name: String, val phone: String, aaaa: Double = 67.3) : ApplicationEventRt176()
    class GetH2hData176(
        val idHome:Int,
        val idAway:Int,
        val typeEventsRt176: TypeEventsRt176,
        val homeName:String,
        val homeScore:Int?,
        val homeLogo:String,
        val awayName:String,
        val awayScore:Int?,
        val awayLogo:String,
        val title:String,) : ApplicationEventRt176()
    data object StartMiniGameRt176:ApplicationEventRt176()
    class SetAnswer(val isRight:Boolean):ApplicationEventRt176()
    data object StopMiniGameRt176:ApplicationEventRt176()
}