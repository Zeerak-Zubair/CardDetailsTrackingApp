package com.example.cardetailstrackingapp.model

import com.example.cardetailstrackingapp.dto.NewOilChangeRecordRequest
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity(name = "oil_change_record")
data class OilChangeRecord(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val vehicleRegistrationNo: String,
    val mileage: Int,
    val limit: Int,
    val date: LocalDate
){
    companion object{
        fun toModel(newOilChangeRecordRequest: NewOilChangeRecordRequest): OilChangeRecord {
            return OilChangeRecord(
                vehicleRegistrationNo = newOilChangeRecordRequest.vehicleRegistrationNo,
                mileage = newOilChangeRecordRequest.mileage,
                limit = newOilChangeRecordRequest.limit,
                date = LocalDate.now()
            )
        }
    }
}