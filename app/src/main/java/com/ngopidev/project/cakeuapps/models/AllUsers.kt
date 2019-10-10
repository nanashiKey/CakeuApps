package com.ngopidev.project.cakeuapps.models


/**
 *   created by Irfan Assidiq on 2019-10-10
 *   email : assidiq.irfan@gmail.com
 **/
class AllUsers {
    lateinit var idx : String
    lateinit var name : String
    lateinit var emailx : String
    lateinit var moneyThisMonth : String
    constructor(){}

    constructor(idx : String, name : String, emailx : String, moneyThisMonth : String){
        this.idx = idx
        this.name = name
        this.emailx = emailx
        this.moneyThisMonth = moneyThisMonth
    }
}