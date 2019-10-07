package com.ngopidev.project.cakeuapps.allAct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.ngopidev.project.cakeuapps.R
import com.ngopidev.project.cakeuapps.appsHelper.Const.Companion.RC_SIGN_IN
import kotlinx.android.synthetic.main.activity_login.*

class LoginAct : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this@LoginAct,gso)


        btnLogin.setOnClickListener {
            startActivity(Intent(this@LoginAct, MainActivity::class.java))
            finish()
        }

        tvRegis.setOnClickListener {
            startActivity(Intent(this@LoginAct, RegisterAct::class.java))
        }

        btn_google.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun firebaseAuthWithGoogleAct(acct : GoogleSignInAccount){
        d("SHOWAuth" , acct.id.toString())

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    d("REPORTOke", "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user)
                }else{
                    w("REPORTError", "signInWithCredential:failure", it.exception)
                    Toast.makeText(this@LoginAct, "Login Error", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }

    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(this@LoginAct, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this@LoginAct, "user unavailable", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            if(data != null){
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try{
                    val account = task.getResult(ApiException::class.java)
                    firebaseAuthWithGoogleAct(account!!)
                }catch (err: ApiException){
                    e("ERRORMESSAGE", err.message!!)
                }
            }else{
                Toast.makeText(this@LoginAct, "data is ${data}", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this@LoginAct, "Request Code is Unknown", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser!= null){
            updateUI(currentUser)
        }
    }

}
