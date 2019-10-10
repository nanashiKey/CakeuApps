package com.ngopidev.project.cakeuapps.appsHelper

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ngopidev.project.cakeuapps.R


/**
 *   created by Irfan Assidiq on 2019-10-07
 *   email : assidiq.irfan@gmail.com
 **/
class AllHelperMethod {
    lateinit var ctx : Context

    constructor(){}
    constructor(ctx : Context){
        this.ctx = ctx
    }
    fun showLongToast(msg : String){
        Toast.makeText(this.ctx, msg, Toast.LENGTH_LONG).show()
    }

    fun showShortToast(msg : String){
        Toast.makeText(this.ctx, msg, Toast.LENGTH_SHORT).show()
    }

    fun underConstructionToast(){
        Toast.makeText(this.ctx, "Function is Under Construction", Toast.LENGTH_SHORT).show()
    }

    fun <T : Any> goTo (gowhere : Class<T>){
        ctx.startActivity(Intent(ctx, gowhere))
    }

    fun setWindowsBarBlue(saved : AppCompatActivity){
        val windows = saved.window
        // clear FLAG_TRANSLUCENT_STATUS flag:
        windows.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        windows.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        // finally change the color
        windows.setStatusBarColor(ContextCompat.getColor(ctx,  R.color.aoiBlue))
    }


}