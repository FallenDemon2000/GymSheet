package com.plcoding.shared.ktx

import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.numberWithFloat

actual fun formatNumber(value: Float): String {
    val formatter = NSNumberFormatter().apply {
        minimumFractionDigits = 0u
        maximumFractionDigits = 2u
        decimalSeparator = "."
    }
    return formatter.stringFromNumber(NSNumber.numberWithFloat(value)) ?: value.toString()
}
