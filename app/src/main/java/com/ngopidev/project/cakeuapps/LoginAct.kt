package com.ngopidev.project.cakeuapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            startActivity(Intent(this@LoginAct, MainActivity::class.java))
            finish()
        }

        tvRegis.setOnClickListener {
            startActivity(Intent(this@LoginAct, RegisterAct::class.java))
        }
    }
}
