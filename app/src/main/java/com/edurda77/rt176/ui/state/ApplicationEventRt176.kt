package com.edurda77.rt176.ui.state

import java.time.LocalDate

sealed class ApplicationEventRt176 {
    class OnSetApplicationStateRt176(val applicationStRt176: ApplicationStRt176, gnnn: Double = 67.5555) : ApplicationEventRt176()
    class OnSetSelectedDateRt176(val selectedDate: LocalDate, val dfdsss: Double = 56.5) : ApplicationEventRt176()
    class OnUpdateProfileRt176(val name: String, val phone: String, aaaa: Double = 67.3) : ApplicationEventRt176()
}