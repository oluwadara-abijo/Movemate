package com.dara.movemate.data

data class Shipment(
    val id: String,
    val name: String,
    val sender: String,
    val receiver: String,
    val status: ShipmentStatus,
    val amount: String,
    val date: String,
    val timeline: String,
)
