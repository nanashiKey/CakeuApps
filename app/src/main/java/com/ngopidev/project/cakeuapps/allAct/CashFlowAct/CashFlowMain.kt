package com.ngopidev.project.cakeuapps.allAct.CashFlowAct

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ngopidev.project.cakeuapps.R
import com.ngopidev.project.cakeuapps.appsHelper.AllHelperMethod
import kotlinx.android.synthetic.main.cash_flow_act.*


/**
 *   created by Irfan Assidiq on 2019-10-09
 *   email : assidiq.irfan@gmail.com
 **/
class CashFlowMain : AppCompatActivity() {
    lateinit var allHelperMethod: AllHelperMethod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cash_flow_act)

        allHelperMethod = AllHelperMethod(this@CashFlowMain)
        allHelperMethod.setWindowsBarBlue(this)

        btn_report.setOnClickListener {
            onBackPressed()
        }

    }
}