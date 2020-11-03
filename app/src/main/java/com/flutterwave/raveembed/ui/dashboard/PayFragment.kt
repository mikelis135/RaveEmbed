package com.flutterwave.raveembed.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.flutterwave.raveandroid.RaveUiManager
import com.flutterwave.raveembed.R

class PayFragment : Fragment() {

    private lateinit var payViewModel: PayViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        payViewModel =
            ViewModelProvider(this).get(PayViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val containers: ConstraintLayout = root.findViewById(R.id.container_body)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        RaveUiManager(this)
            .setAmount(3.0)
            .setCurrency("NGN")
            .setTxRef("jbhds")
            .onStagingEnv(false)
            .showStagingLabel(false)
            .setfName("hgfv")
            .setlName("ghb")
            .setEncryptionKey("d19b1c9adf4128ceccc41634")
            .setPublicKey("FLWPUBK-9f0d0dd7dc219618b2b7892df65c0db3-X")
            .acceptCardPayments(true)
//            .acceptAccountPayments(true)
            .setPhoneNumber("08132383284")
            .setEmail("mikelis135@gmail.com")
            .embedFragment(R.id.container_body, requireActivity() as AppCompatActivity)
            .initialize()

        return root
    }


}