package com.ngopidev.project.cakeuapps.allAct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.ngopidev.project.cakeuapps.R
import com.ngopidev.project.cakeuapps.appsHelper.AllHelperMethod
import com.ngopidev.project.cakeuapps.appsHelper.PrefsHelper
import com.ngopidev.project.cakeuapps.models.AllUsers
import kotlinx.android.synthetic.main.activity_nominal.*


/**
 *   created by Irfan Assidiq on 2019-10-07
 *   email : assidiq.irfan@gmail.com
 **/
class FirstMoney : AppCompatActivity() {
    lateinit var prefsHelper: PrefsHelper
    lateinit var allHelperMethod: AllHelperMethod
    lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nominal)

        dbRef = FirebaseDatabase.getInstance().reference

        prefsHelper = PrefsHelper(this@FirstMoney)
        allHelperMethod = AllHelperMethod(this@FirstMoney)
        allHelperMethod.setWindowsBarBlue(this)
        btn_ok.setOnClickListener {
            val money = et_firstMoney.text.toString()
            val uid = prefsHelper.getIdUser()
            val email = prefsHelper.getEmail()
            if(money.isNotEmpty()){
                val allusers = AllUsers(uid!!, email!!, email, money)
                dbRef.child("allusers/${uid}").setValue(allusers)
                allHelperMethod.goTo(MainActivity::class.java)
                finish()
            }else{
                val allusers = AllUsers(uid!!, email!!, email, "0")
                dbRef.child("allusers/${uid}").setValue(allusers)
                allHelperMethod.goTo(MainActivity::class.java)
                finish()
            }
        }
    }
}