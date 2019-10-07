package com.ngopidev.project.cakeuapps.appsHelper

import android.content.Context
import android.content.Intent
import android.widget.Toast


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
}