package com.edurda77.rt176.ui.state

sealed interface ApplicationStRt176 {
    class LoadingRt176(valdfg: Int = 67) : ApplicationStRt176
    class StartRt176(valdfg: Int = 67) : ApplicationStRt176
    class IncomingEventsRt176(val typeEventsRt176: TypeEventsRt176) : ApplicationStRt176
    class GameRt176 (valdfg: Int = 67) : ApplicationStRt176
    class Profile(val typeProfileRt176: TypeProfileRt176) : ApplicationStRt176
    class LiveEventsRt176(val typeEventsRt176: TypeEventsRt176) : ApplicationStRt176
}

sealed interface TypeEventsRt176 {
    class FootballRt176 (valdfg: Int = 67) : TypeEventsRt176
    class BasketballRt176(valdfg: Int = 67) : TypeEventsRt176
    class HockeyRt176(valdfg: Int = 67) : TypeEventsRt176
}

sealed interface TypeProfileRt176 {
    class DataRt176 (valdfg: Int = 67) : TypeProfileRt176
    class EditDataRt176(valdfg: Int = 67) : TypeProfileRt176
}