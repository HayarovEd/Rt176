package com.edurda77.rt176.ui.state

sealed interface ApplicationStRt176 {
    class LoadingRt176(val dfg: Int = 67) : ApplicationStRt176
    class StartRt176(val dfg: Int = 67) : ApplicationStRt176
    class EventsRt176(val typeEventsRt176: TypeEventsRt176, val sddff: Int  =12) : ApplicationStRt176
    class GameRt176(valdfg: Int = 67) : ApplicationStRt176
    class ProfileRt176(val typeProfileRt176: TypeProfileRt176) : ApplicationStRt176
    class H2h(
        val homeName:String,
        val homeScore:Int?,
        val awayName:String,
        val awayScore:Int?,
        val title:String,
        val homeLogo:String,
        val awayLogo:String,
        val awayColor:Int,
        val homeColor:Int,
        val icon:Int,
    ) : ApplicationStRt176
    class MiniGameRt176(val typeMiniGameRt176: TypeMiniGameRt176) : ApplicationStRt176
}


sealed interface TypeEventsRt176 {
    class GamesOfDayRt176(val typeGame: TypeGame) : TypeEventsRt176
    class LiveGamesRt176(val typeGame: TypeGame) : TypeEventsRt176
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

sealed interface TypeMiniGameRt176 {
    data object PlayRt176:TypeMiniGameRt176
    data object ResultRt176:TypeMiniGameRt176
}