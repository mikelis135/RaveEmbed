package com.flutterwave.raveembed.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RaveData {

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("txRef")
    @Expose
    var txRef: String? = null

    @SerializedName("orderRef")
    @Expose
    var orderRef: String? = null

    @SerializedName("flwRef")
    @Expose
    var flwRef: String? = null

    @SerializedName("redirectUrl")
    @Expose
    var redirectUrl: String? = null

    @SerializedName("device_fingerprint")
    @Expose
    var deviceFingerprint: String? = null

    @SerializedName("settlement_token")
    @Expose
    var settlementToken: Any? = null

    @SerializedName("cycle")
    @Expose
    var cycle: String? = null

    @SerializedName("amount")
    @Expose
    var amount: Double? = null

    @SerializedName("charged_amount")
    @Expose
    var chargedAmount: Double? = null

    @SerializedName("appfee")
    @Expose
    var appfee: Double? = null

    @SerializedName("merchantfee")
    @Expose
    var merchantfee: Int? = null

    @SerializedName("merchantbearsfee")
    @Expose
    var merchantbearsfee: Int? = null

    @SerializedName("chargeResponseCode")
    @Expose
    var chargeResponseCode: String? = null

    @SerializedName("raveRef")
    @Expose
    var raveRef: String? = null

    @SerializedName("chargeResponseMessage")
    @Expose
    var chargeResponseMessage: String? = null

    @SerializedName("authModelUsed")
    @Expose
    var authModelUsed: String? = null

    @SerializedName("currency")
    @Expose
    var currency: String? = null

    @SerializedName("IP")
    @Expose
    var ip: String? = null

    @SerializedName("narration")
    @Expose
    var narration: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("modalauditid")
    @Expose
    var modalauditid: String? = null

    @SerializedName("vbvrespmessage")
    @Expose
    var vbvrespmessage: String? = null

    @SerializedName("authurl")
    @Expose
    var authurl: String? = null

    @SerializedName("vbvrespcode")
    @Expose
    var vbvrespcode: String? = null

    @SerializedName("acctvalrespmsg")
    @Expose
    var acctvalrespmsg: Any? = null

    @SerializedName("acctvalrespcode")
    @Expose
    var acctvalrespcode: Any? = null

    @SerializedName("paymentType")
    @Expose
    var paymentType: String? = null

    @SerializedName("paymentPlan")
    @Expose
    var paymentPlan: Any? = null

    @SerializedName("paymentPage")
    @Expose
    var paymentPage: Any? = null

    @SerializedName("paymentId")
    @Expose
    var paymentId: String? = null

    @SerializedName("fraud_status")
    @Expose
    var fraudStatus: String? = null

    @SerializedName("charge_type")
    @Expose
    var chargeType: String? = null

    @SerializedName("is_live")
    @Expose
    var isLive: Int? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

    @SerializedName("updatedAt")
    @Expose
    var updatedAt: String? = null

    @SerializedName("deletedAt")
    @Expose
    var deletedAt: Any? = null

    @SerializedName("customerId")
    @Expose
    var customerId: Int? = null

    @SerializedName("AccountId")
    @Expose
    var accountId: Int? = null

    @SerializedName("customer.phone")
    @Expose
    var customerPhone: Any? = null

    @SerializedName("customer.fullName")
    @Expose
    var customerFullName: String? = null

    @SerializedName("customer.customertoken")
    @Expose
    var customerCustomertoken: Any? = null

    @SerializedName("customer.email")
    @Expose
    var customerEmail: String? = null

    @SerializedName("customer.createdAt")
    @Expose
    var customerCreatedAt: String? = null

    @SerializedName("customer.updatedAt")
    @Expose
    var customerUpdatedAt: String? = null

    @SerializedName("customer.deletedAt")
    @Expose
    var customerDeletedAt: Any? = null

    @SerializedName("customer.AccountId")
    @Expose
    var customerAccountId: Int? = null

    @SerializedName("meta")
    @Expose
    var meta: List<Any>? = null

}
