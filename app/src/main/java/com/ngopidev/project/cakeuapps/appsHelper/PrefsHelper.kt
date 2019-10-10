package com.ngopidev.project.cakeuapps.appsHelper

import android.content.Context
import android.content.SharedPreferences


/**
 *   created by Irfan Assidiq on 2019-10-07
 *   email : assidiq.irfan@gmail.com
 **/
class PrefsHelper(var mContext: Context) {
    private val appsName = "CaKeuApps"
    private val firstInput = "FIRSTINPUT"
    private val hasInputCount = "HASINPUT"
    private val idUser = "IDUSERS"
    private val emailUser = "EMAILS"
    private var sharedSet : SharedPreferences

    init {
        sharedSet = mContext.getSharedPreferences(appsName, Context.MODE_PRIVATE)
    }

    val edit = sharedSet.edit()

    fun setFirstInput(nominal : Int){
        edit.putInt(firstInput, nominal)
        edit.apply()
    }
    fun getFirstInput() : Int{
        return sharedSet.getInt(firstInput, 0)
    }

    fun setHasInput(isInputed : Boolean){
        edit.putBoolean(hasInputCount, isInputed)
        edit.apply()
    }
    fun getHasInput() : Boolean{
        return sharedSet.getBoolean(hasInputCount, false)
    }

    fun setIdUser(uid : String){
        edit.putString(idUser, uid)
        edit.apply()
    }

    fun getIdUser() : String?{
        return sharedSet.getString(idUser, "")
    }

    fun setEmail(email : String){
        edit.putString(emailUser, email)
        edit.apply()
    }

    fun getEmail() : String?{
        return sharedSet.getString(emailUser, "")
    }
}