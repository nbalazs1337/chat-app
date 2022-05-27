package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_register.setOnClickListener {
            val username = txt_username.text.toString()
            val email = txt_email.text.toString()
            val pass = txt_pass.text.toString()
            Log.d("MainActivity", "username is: $username")
            Log.d("MainActivity", "email is: $email" )
            Log.d("MainActivity", "pass is:   $pass")
        }

        txt_have.setOnClickListener{
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }



    }
}