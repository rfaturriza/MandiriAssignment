package com.rizz.mandiri.assignment.core.model

import com.google.gson.annotations.SerializedName
import com.rizz.mandiri.assignment.core.utils.extension.Empty

open class BaseResponse {
    @SerializedName("success")
    var isSuccessful: Boolean = false
    @SerializedName("status_message")
    var message: String = String.Empty
    @SerializedName("status_code")
    var statusCode: String = String.Empty
}