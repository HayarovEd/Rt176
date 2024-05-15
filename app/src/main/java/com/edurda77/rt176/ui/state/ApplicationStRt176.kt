package com.edurda77.rt176.ui.state

sealed interface ApplicationStRt176 {
    class LoadingRt176(valdfg: Int = 67) : ApplicationStRt176
    class StartRt176(valdfg: Int = 67) : ApplicationStRt176
    class IncomingEventsRt176(val typeEventsRt171: TypeEventsRt171) : ApplicationStRt176
    class GameRt176 (valdfg: Int = 67) : ApplicationStRt176
    class Profile(val typeProfileRt171: TypeProfileRt171) : ApplicationStRt176
    class LiveEventsRt176(val typeEventsRt171: TypeEventsRt171) : ApplicationStRt176
}

sealed interface TypeEventsRt171 {
    class FootballRt171 (valdfg: Int = 67) : TypeEventsRt171
    class BasketballRt171(valdfg: Int = 67) : TypeEventsRt171
    class HockeyRt171(valdfg: Int = 67) : TypeEventsRt171
}

sealed interface TypeProfileRt171 {
    class DataRt171 (valdfg: Int = 67) : TypeProfileRt171
    class EditDataRt171(valdfg: Int = 67) : TypeProfileRt171
}