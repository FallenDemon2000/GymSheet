package com.plcoding.shared.ktx

import java.text.DecimalFormat

actual fun formatNumber(value: Float): String =
    DecimalFormat("#.##").format(value)
