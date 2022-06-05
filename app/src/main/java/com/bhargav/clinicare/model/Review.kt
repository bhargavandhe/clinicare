package com.bhargav.clinicare.model

data class Review(
    val uid: String,
    val rating: Float,
    val review: String,
    val likes: List<String>
) {
    override fun toString(): String {
        return "Review(uid='$uid', rating=$rating, review='$review', likes=$likes)"
    }
}
