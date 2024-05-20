package com.edurda77.rt176.domain.model

import com.edurda77.rt176.R

enum class Sport(val image: Int, val title: String){
    BASKETBALL(R.drawable.basketball, "Баскетбол"),
    FOOTBALL(R.drawable.football, "Футбол"),
    GOLF(R.drawable.holf, "Гольф"),
    HOKKEY(R.drawable.hokkey, "Хоккей"),
    VOLLEYBALL (R.drawable.volleyball, "Волейбол")
}

enum class NameSport(val titleSport: String) {
    BASKETBALL("Баскетбол"),
    FOOTBALL("Футбол"),
    GOLF("Гольф"),
    HOKKEY("Хоккей"),
    VOLLEYBALL ("Волейбол")
}
