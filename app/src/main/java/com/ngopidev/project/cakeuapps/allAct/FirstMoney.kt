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
        prefsHelper = PrefsHelper(this@FirstMoney)
        allHelperMethod = AllHelperMethod(this@FirstMoney)
        allHelperMethod.setWindowsBarBlue(this)

        dbRef = FirebaseDatabase.getInstance().reference
        val uid = prefsHelper.getIdUser()
        dbRef.child("alluser/${uid}")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(p0: DataSnapshot) {
                    for(howMoney in p0.children){
                        if(howMoney.child("moneyThisMonth").value != 0){
                            allHelperMethod.goTo(MainActivity::class.java)
                            finish()
                        }
                    }
                }
                override fun onCancelled(p0: DatabaseError) {

                }

            })

        btn_ok.setOnClickListener {
            val money = et_firstMoney.text.toString()
//            val uid = prefsHelper.getIdUser()
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