package com.ngopidev.project.cakeuapps.allAct.CashFlowAct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ngopidev.project.cakeuapps.R
import kotlinx.android.synthetic.main.cash_flow_act.*


/**
 *   created by Irfan Assidiq on 2019-10-09
 *   email : assidiq.irfan@gmail.com
 **/
class CashFlowMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cash_flow_act)

        btn_report.setOnClickListener {
            onBackPressed()
        }

    }
}