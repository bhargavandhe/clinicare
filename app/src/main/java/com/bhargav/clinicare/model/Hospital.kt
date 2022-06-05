package com.bhargav.clinicare.model

data class Hospital(
    val name: String,
    val address: String,
    val photoURL: String,
    val doctors: List<Doctor> = listOf(),
    val about: String,
    val reviews: List<Review>
) {
    override fun toString(): String {
        return "Hospital(name='$name', address='$address', photoURL='$photoURL', doctors=$doctors, about='$about', reviews=$reviews)"
    }
}
