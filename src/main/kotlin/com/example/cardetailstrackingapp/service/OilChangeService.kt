package com.example.cardetailstrackingapp.service

import com.example.cardetailstrackingapp.dto.NewOilChangeRecordRequest
import com.example.cardetailstrackingapp.dto.NextOilChangeRequest
import com.example.cardetailstrackingapp.model.OilChangeRecord

interface OilChangeService {

    fun saveOilChangeRecord(newOilChangeRequest: NewOilChangeRecordRequest): OilChangeRecord
    fun findOilChangeRecord(id: Long): OilChangeRecord
    fun findOilChangeRecordByVehicleRegistrationNo(vehicleRegistrationNo: String): List<OilChangeRecord>
    //fun findLatestOilChangeRecordByVehicleRegistrationNo(vehicleRegistrationNo: String): OilChangeRecord
    //fun updateOilChangeRecord()
    fun calculateNextOilChangeDate(nextOilChangeRequest: NextOilChangeRequest)
}