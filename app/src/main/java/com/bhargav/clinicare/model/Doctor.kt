package com.bhargav.clinicare.model

data class Doctor(
    val doctorName: String = "",
    val gender: Gender = Gender.UNDISCLOSED,
    val role: String = "",
    val phone: String = "",
    val photoURL: String = "",
) {
    override fun toString(): String {
        return "Doctor(doctorName='$doctorName', gender=$gender, role='$role', phone='$phone', photoURL='$photoURL')"
    }
}
