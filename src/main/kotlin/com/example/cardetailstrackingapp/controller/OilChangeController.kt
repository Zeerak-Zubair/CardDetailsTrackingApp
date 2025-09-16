package com.example.cardetailstrackingapp.controller

import com.example.cardetailstrackingapp.service.OilChangeService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/oilchange")
class OilChangeController(
    val oilChangeService: OilChangeService
) {


}