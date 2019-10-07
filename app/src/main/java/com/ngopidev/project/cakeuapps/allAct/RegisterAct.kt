package com.ngopidev.project.cakeuapps.allAct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.ngopidev.project.cakeuapps.R
import com.ngopidev.project.cakeuapps.appsHelper.AllHelperMethod
import kotlinx.android.synthetic.main.activity_register.*

class RegisterAct : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    lateinit var allHelperMethod: AllHelperMethod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        allHelperMethod = AllHelperMethod(this@RegisterAct)

        val windows = window
        // clear FLAG_TRANSLUCENT_STATUS flag:
        windows.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        windows.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        // finally change the color
        windows.setStatusBarColor(ContextCompat.getColor(this@RegisterAct,  R.color.aoiBlue))

        btn_register.setOnClickListener {
            val email = et_email.text.toString()
            val pass = et_pass.text.toString()

            if(email.isEmpty() && pass.isEmpty()){
                allHelperMethod.showLongToast("please fill all empty coloumn")
            }else{
                auth.createUserWithEmailAndPassword(email, pass).addOnSuccessListener {
                    allHelperMethod.showShortToast("user ${it.user!!.email} has registered")
                    onBackPressed()
                }.addOnFailureListener {
                    allHelperMethod.showShortToast("error to registered user")
                }
            }
        }
    }
}
