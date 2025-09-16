package com.example.cardetailstrackingapp.repository

import com.example.cardetailstrackingapp.model.OilChangeRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface OilChangeRepository : JpaRepository<OilChangeRecord, Long>{

    fun findByVehicleRegistrationNo(vehicleRegistrationNo: String): List<OilChangeRecord>

    @Query("SELECT * FROM oil_change_record ocr WHERE ocr.vehicleRegistrationNo = :vehicleRegistrationNo ORDER BY ocr.date DESC LIMIT 1", nativeQuery = true)
    fun findLatestVehicleOilChangeRecord(@Param("vehicleRegistrationNo") vehicleRegistrationNo: String): OilChangeRecord
}