package com.bhargav.clinicare.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bhargav.clinicare.R

private val dm_sans_bold = Font(R.font.dm_sans_bold, FontWeight.Bold)
private val dm_sans_regular = Font(R.font.dm_sans_regular, FontWeight.Normal)
private val dm_sans_medium = Font(R.font.dm_sans_medium, FontWeight.Medium)

private val dmSans = FontFamily(fonts = listOf(dm_sans_bold, dm_sans_regular, dm_sans_medium))

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Medium,
        fontSize = 102.sp,
        letterSpacing = (-1.5).sp,
    ),
    h2 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Medium,
        fontSize = 64.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Medium,
        fontSize = 51.sp
    ),
    h4 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        letterSpacing = (0.25).sp
    ),
    h5 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    h6 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = (0.15).sp
    ),
    subtitle1 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = (0.15).sp

    ),
    subtitle2 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = (0.1).sp
    ),
    body1 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = (0.5).sp
    ),
    body2 = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = (0.25).sp
    ),
    button = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = (1.25).sp
    ),
    caption = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        letterSpacing = (0.4).sp,
    ),
    overline = TextStyle(
        fontFamily = dmSans,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        letterSpacing = (1.5).sp,
    )
)
