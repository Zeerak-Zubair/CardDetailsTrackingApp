package com.example.cardetailstrackingapp.dto

import com.example.cardetailstrackingapp.model.OilChangeRecord
import java.time.LocalDate

data class NewOilChangeRecordRequest(
    val vehicleRegistrationNo: String,
    val mileage: Int,
    val date: LocalDate,
    val limit: Int
)