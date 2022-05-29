package com.example.chatapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LogInActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email = txt_log_email.text.toString()
        val pass = txt_log_pass.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass)
           // .addOnCompleteListener()

        txt_backToRegister.setOnClickListener {
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        }
    }


}