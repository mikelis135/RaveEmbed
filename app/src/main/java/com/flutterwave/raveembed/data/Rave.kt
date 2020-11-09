package com.flutterwave.raveembed.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rave {

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var raveData: RaveData? = null

}
