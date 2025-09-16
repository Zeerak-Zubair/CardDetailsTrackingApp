package com.example.cardetailstrackingapp.dto

import java.time.LocalDate

data class NextOilChangeRequest (
    val vehicleRegistrationNo: String,
    val currentMileage: Int,
    val date: LocalDate
)