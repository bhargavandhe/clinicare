package com.bhargav.clinicare.model

data class Prescription(
    val hospital: Hospital,
    val doctor: Doctor,
    val time: Long,
    val medicines: List<Medicine>
) {
    override fun toString(): String {
        return "Prescription(hospital=$hospital, doctor=$doctor, time=$time, medicines=$medicines)"
    }
}
