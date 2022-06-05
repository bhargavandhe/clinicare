package com.bhargav.clinicare.model

enum class Time {
    MORNING, AFTERNOON, EVENING, NIGHT
}

data class Medicine(
    val medicineName: String,
    val quantity: Float,
    val consumptionTime: Time
) {
    override fun toString(): String {
        return "Medicine(medicineName='$medicineName', quantity=$quantity, consumptionTime=$consumptionTime)"
    }
}
