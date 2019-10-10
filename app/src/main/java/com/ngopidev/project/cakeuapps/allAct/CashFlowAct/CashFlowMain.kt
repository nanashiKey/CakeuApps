package com.ngopidev.project.cakeuapps.allAct.CashFlowAct

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
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

        spn_type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                allHelperMethod.showShortToast("please select one of the options")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 1){
                    ti_desc.visibility = View.VISIBLE
                }else{
                    ti_desc.visibility = View.GONE
                }
            }

        }

        btn_report.setOnClickListener {
            onBackPressed()
        }

    }
}