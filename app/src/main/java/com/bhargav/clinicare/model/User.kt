package com.bhargav.clinicare.model

data class User(
    val name: String = "User",
    val email: String = "abc@xyz.com",
    val phone: String = "0",
    val gender: Gender = Gender.UNDISCLOSED,
    val birthday: String = "01/01/1976",
    val height: Long = 0L,
    val weight: Long = 0L,
    val photoURL: String = "",
    val prescriptions: List<Prescription> = listOf()
) {
    override fun toString(): String {
        return "User(name='$name', email='$email', phone='$phone', gender='$gender', birthday='$birthday', height=$height, weight=$weight, photoURL='$photoURL', prescriptions=$prescriptions)"
    }
}
