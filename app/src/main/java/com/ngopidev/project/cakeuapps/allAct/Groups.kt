package com.ngopidev.project.cakeuapps.allAct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ngopidev.project.cakeuapps.R
import com.ngopidev.project.cakeuapps.appsHelper.AllHelperMethod
import com.ngopidev.project.cakeuapps.appsHelper.PrefsHelper
import kotlinx.android.synthetic.main.groups_layout.*


/**
 *   created by Irfan Assidiq on 2019-10-24
 *   email : assidiq.irfan@gmail.com
 **/
class Groups : AppCompatActivity(){

    lateinit var allHelperMethod: AllHelperMethod
    lateinit var dbRef : DatabaseReference
    lateinit var prefsHelper : PrefsHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.groups_layout)

        allHelperMethod = AllHelperMethod(this@Groups)
        allHelperMethod.setWindowsBarBlue(this)
        prefsHelper = PrefsHelper(this@Groups)
        val idUser = prefsHelper.getIdUser()
        dbRef = FirebaseDatabase.getInstance().reference
        btn_createGroup.setOnClickListener {
            val groupName = et_group.text.toString()
            val uniqueCode = et_unCode.text.toString()

            if(groupName.isEmpty() && uniqueCode.isEmpty()){
                allHelperMethod.showShortToast("please fill all empty form")
            }else{
                dbRef.child("groups/${idUser}/groupName").setValue(groupName)
                dbRef.child("groups/${idUser}/groupUnCode").setValue(uniqueCode)
                dbRef.child("groups/${idUser}/groupIcon").setValue("")
                dbRef.child("groups/${idUser}/groupDetail").setValue("")
                dbRef.child("groups/${idUser}/groupMembers").setValue("")
                allHelperMethod.showShortToast("Group has been created")
                onBackPressed()
            }
        }
    }
}