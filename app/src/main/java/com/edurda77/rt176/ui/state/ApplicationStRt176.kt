package com.edurda77.rt176.ui.state

sealed interface ApplicationStRt176 {
    class LoadingRt176(valdfg: Int = 67) : ApplicationStRt176
    class StartRt176(valdfg: Int = 67) : ApplicationStRt176
    class EventsRt176(val typeEventsRt176: TypeEventsRt176) : ApplicationStRt176
    class GameRt176(valdfg: Int = 67) : ApplicationStRt176
    class Profile(val typeProfileRt176: TypeProfileRt176) : ApplicationStRt176
}


sealed interface TypeEventsRt176 {
    class GamesOfDay(val typeGame: TypeGame) : TypeEventsRt176
    class LiveGames(val typeGame: TypeGame) : TypeEventsRt176
}

sealed interface TypeGame {
    class FootballRt176(valdfg: Int = 67) : TypeGame
    class BasketballRt176(valdfg: Int = 67) : TypeGame
    class HockeyRt176(valdfg: Int = 67) : TypeGame
}

sealed interface TypeProfileRt176 {
    class DataRt176(valdfg: Int = 67) : TypeProfileRt176
    class EditDataRt176(valdfg: Int = 67) : TypeProfileRt176
}