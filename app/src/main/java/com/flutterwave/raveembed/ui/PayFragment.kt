package com.flutterwave.raveembed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import com.flutterwave.raveandroid.RavePayActivity
import com.flutterwave.raveandroid.RaveUiManager
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants.ENCRYPTION_KEY
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants.PUBLIC_KEY
import com.flutterwave.raveembed.R
import com.flutterwave.raveembed.data.Rave
import com.google.gson.Gson

class PayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_pay, container, false)

        root.findViewById<Button>(R.id.payButton).setOnClickListener {
            payWithFlutterwave()
            checkPaymentResponse()
        }

        return root
    }

    private fun checkPaymentResponse() {

        parentFragmentManager.setFragmentResultListener(
            RaveConstants.RAVE_REQUEST_KEY,
            this,
            FragmentResultListener { _, result ->
                val message = result.getString("response")
                val resultCode = result.getInt("resultCode")
                val gson = Gson()
                val rave = gson.fromJson(message, Rave::class.java)

                rave?.raveData?.let {
                    when (resultCode) {
                        RavePayActivity.RESULT_SUCCESS -> {
                            Toast.makeText(requireContext(), it.vbvrespmessage, Toast.LENGTH_LONG)
                                .show()
                        }
                        RavePayActivity.RESULT_ERROR -> {
                            Toast.makeText(requireContext(), it.vbvrespmessage, Toast.LENGTH_LONG)
                                .show()
                        }
                        RavePayActivity.RESULT_CANCELLED -> {
                            Toast.makeText(requireContext(), "Payment Stopped", Toast.LENGTH_LONG)
                                .show()
                        }
                        else -> {
                        }
                    }
                }
            })
    }

    private fun payWithFlutterwave() {

        RaveUiManager(this)
            .setAmount(30.0)
            .setEmail("mikelis135@gmail.com")
            .setTxRef("txref" + (Math.random() * 99999).toInt())
            .acceptCardPayments(true)
            .acceptAccountPayments(true)
            .onStagingEnv(true)
            .setfName("Taiwo")
            .shouldDisplayFee(false)
            .setPhoneNumber("08132383284")
            .setlName("Adebayo")
            .setPublicKey(PUBLIC_KEY)
            .setEncryptionKey(ENCRYPTION_KEY)
            .embedFragment(R.id.container_fragment, requireActivity() as AppCompatActivity)
            .initialize()
    }


}