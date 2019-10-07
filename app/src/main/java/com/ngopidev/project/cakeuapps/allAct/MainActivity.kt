package com.ngopidev.project.cakeuapps.allAct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.ngopidev.project.cakeuapps.R
import com.ngopidev.project.cakeuapps.appsHelper.AllHelperMethod
import com.ngopidev.project.cakeuapps.appsHelper.PrefsHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    lateinit var googleSignInAccount: GoogleSignInClient
    lateinit var allHelperMethod: AllHelperMethod
    lateinit var prefsHelper: PrefsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val windows = window
        // clear FLAG_TRANSLUCENT_STATUS flag:
        windows.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        windows.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        // finally change the color
        windows.setStatusBarColor(ContextCompat.getColor(this@MainActivity,  R.color.aoiBlue))


        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInAccount = GoogleSignIn.getClient(this@MainActivity,gso)
        allHelperMethod = AllHelperMethod(this@MainActivity)
        prefsHelper = PrefsHelper(this@MainActivity)
        val getMoney = prefsHelper.getFirstInput()
        tv_nominal.text = "your saving is :\n${getMoney}"



        //cash flow function
        fr_cashFlow.setOnClickListener {
            allHelperMethod.underConstructionToast()
        }

        //cash all data function
        fr_seeAlldata.setOnClickListener {
            allHelperMethod.underConstructionToast()
        }

        //cash history function
        fr_cashHistory.setOnClickListener {
            allHelperMethod.underConstructionToast()
        }

        //inviteQr function
        fr_inviteQR.setOnClickListener {
            allHelperMethod.underConstructionToast()
        }

        //add data flow function
        fr_add.setOnClickListener {
            allHelperMethod.underConstructionToast()
        }

        //logout function
        logout.setOnClickListener {
            signOut()
            allHelperMethod.goTo(LoginAct::class.java)
        }
    }

    private fun signOut(){
        auth.signOut()
        googleSignInAccount.signOut()
    }
}
