package com.ngopidev.project.cakeuapps.allAct

import android.animation.Animator
import android.animation.LayoutTransition
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.ngopidev.project.cakeuapps.R
import com.ngopidev.project.cakeuapps.allAct.CashFlowAct.CashFlowMain
import com.ngopidev.project.cakeuapps.appsHelper.AllHelperMethod
import com.ngopidev.project.cakeuapps.appsHelper.PrefsHelper
import com.ngopidev.project.cakeuapps.models.AllUsers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    lateinit var googleSignInAccount: GoogleSignInClient
    lateinit var allHelperMethod: AllHelperMethod
    lateinit var prefsHelper: PrefsHelper
    lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allHelperMethod = AllHelperMethod(this@MainActivity)
        allHelperMethod.setWindowsBarBlue(this)
        dbRef = FirebaseDatabase.getInstance().getReference("allusers")

        val animtest = AnimationUtils.loadAnimation(this@MainActivity, R.anim.slideup)
        foranim1.startAnimation(animtest)
        foranim2.startAnimation(animtest)
        foranim3.startAnimation(animtest)
        foranim4.startAnimation(animtest)
        foranim5.startAnimation(animtest)

        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInAccount = GoogleSignIn.getClient(this@MainActivity,gso)
        prefsHelper = PrefsHelper(this@MainActivity)
        val uids = prefsHelper.getIdUser()

        dbRef.child(uids!!).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                val getData = p0.getValue(AllUsers::class.java)
                if(getData != null){
                    tv_nominal.text = "your current money is :\n${getData!!.moneyThisMonth}"
                }else{
                    allHelperMethod.showShortToast("there is an error")
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                allHelperMethod.showShortToast(p0.message)
            }

        })



        //cash flow function
        fr_cashFlow.setOnClickListener {
            allHelperMethod.goTo(CashFlowMain::class.java)
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
            allHelperMethod.goTo(Groups::class.java)
        }

        //logout function
        logout.setOnClickListener {
            signOut()
        }

        MobileAds.initialize(this)
        val adReq = AdRequest.Builder().build()
        adView.loadAd(adReq)

        adView.adListener = object : AdListener(){
            override fun onAdImpression() {
                super.onAdImpression()
            }

            override fun onAdLeftApplication() {
                super.onAdLeftApplication()
            }

            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdFailedToLoad(p0: Int) {
                super.onAdFailedToLoad(p0)
                allHelperMethod.showShortToast("Ads Failed to Load")
            }

            override fun onAdClosed() {
                super.onAdClosed()
            }

            override fun onAdOpened() {
                super.onAdOpened()
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
            }

        }
    }

    private fun signOut(){
        auth.signOut()
        googleSignInAccount.signOut()
        allHelperMethod.goTo(LoginAct::class.java)
        finish()
    }
}
