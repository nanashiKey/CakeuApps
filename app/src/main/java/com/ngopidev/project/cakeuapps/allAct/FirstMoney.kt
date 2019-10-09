package com.ngopidev.project.cakeuapps.allAct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ngopidev.project.cakeuapps.R
import com.ngopidev.project.cakeuapps.appsHelper.AllHelperMethod
import com.ngopidev.project.cakeuapps.appsHelper.PrefsHelper
import kotlinx.android.synthetic.main.activity_nominal.*


/**
 *   created by Irfan Assidiq on 2019-10-07
 *   email : assidiq.irfan@gmail.com
 **/
class FirstMoney : AppCompatActivity() {
    lateinit var prefsHelper: PrefsHelper
    lateinit var allHelperMethod: AllHelperMethod
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nominal)

        prefsHelper = PrefsHelper(this@FirstMoney)
        allHelperMethod = AllHelperMethod(this@FirstMoney)
        allHelperMethod.setWindowsBarBlue(this)
        btn_ok.setOnClickListener {
            val money = et_firstMoney.text.toString()
            if(money.isEmpty()){
                prefsHelper.setFirstInput(0)
                prefsHelper.setHasInput(true)
                allHelperMethod.goTo(MainActivity::class.java)
                finish()
            }else{
                prefsHelper.setFirstInput(money.toInt())
                prefsHelper.setHasInput(true)
                allHelperMethod.goTo(MainActivity::class.java)
                finish()
            }
        }
    }
}