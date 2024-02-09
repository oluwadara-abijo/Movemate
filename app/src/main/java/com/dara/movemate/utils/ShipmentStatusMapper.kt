package com.dara.movemate.utils

import com.dara.movemate.data.ShipmentStatus
import com.dara.movemate.data.ShipmentStatus.Cancelled
import com.dara.movemate.data.ShipmentStatus.Completed
import com.dara.movemate.data.ShipmentStatus.InProgress
import com.dara.movemate.data.ShipmentStatus.Loading
import com.dara.movemate.data.ShipmentStatus.Pending
import com.dara.movemate.data.ShipmentStatus.WaitingToCollect

fun ShipmentStatus.mapStatus(): String {
    return when (this) {
        InProgress -> "in-progress"
        Completed -> "completed"
        Pending -> "pending"
        WaitingToCollect -> "Waiting to collect"
        Cancelled -> "cancelled"
        Loading -> "loading"
    }
}
