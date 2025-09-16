package com.example.cardetailstrackingapp.service.impl

import com.example.cardetailstrackingapp.dto.NewOilChangeRecordRequest
import com.example.cardetailstrackingapp.dto.NextOilChangeRequest
import com.example.cardetailstrackingapp.model.OilChangeRecord
import com.example.cardetailstrackingapp.repository.OilChangeRepository
import com.example.cardetailstrackingapp.service.OilChangeService
import org.springframework.stereotype.Service

@Service
class OilChangeServiceImpl(
    val oilChangeRepository: OilChangeRepository
): OilChangeService {

    override fun saveOilChangeRecord(newOilChangeRequest: NewOilChangeRecordRequest): OilChangeRecord {
        return oilChangeRepository.save(OilChangeRecord.toModel(newOilChangeRequest))
    }

    override fun findOilChangeRecord(id: Long): OilChangeRecord {
        return oilChangeRepository.findById(id).get()
    }

    override fun findOilChangeRecordByVehicleRegistrationNo(vehicleRegistrationNo: String): List<OilChangeRecord> {
        return oilChangeRepository.findByVehicleRegistrationNo(vehicleRegistrationNo)
    }

//    override fun findLatestOilChangeRecordByVehicleRegistrationNo(vehicleRegistrationNo: String): OilChangeRecord {
//        TODO("Not yet implemented")
//    }

//    override fun updateOilChangeRecord() {
//        TODO("Not yet implemented")
//    }

    override fun calculateNextOilChangeDate(nextOilChangeRequest: NextOilChangeRequest){
        val previousOilChangeRecord = findVehicleOilChangeRecord(nextOilChangeRequest.vehicleRegistrationNo)!!
        val p = Period.between(previousOilChangeRecord.date, nextOilChangeRequest.date)
        val days = p.days
        val distanceTravelled = nextOilChangeRequest.currentMileage - previousOilChangeRecord.mileage

        val remainingDays = 0L
        if (distanceTravelled < previousOilChangeRecord.limit) {
            val rate = distanceTravelled / days
            val remainingDays =( (previousOilChangeRecord.mileage + previousOilChangeRecord.limit ) / rate).toLong()
        }

        return nextOilChangeRequest.date.plusDays(remainingDays)
    }
}