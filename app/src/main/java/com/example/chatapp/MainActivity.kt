package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_register.setOnClickListener {
            performRegister()
        }

        txt_have.setOnClickListener{
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }



    }
    private fun performRegister(){
        val username = txt_username.text.toString()
        val email = txt_email.text.toString()
        val pass = txt_pass.text.toString()

        if(email.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "Please enter text in email/pass", Toast
                .LENGTH_SHORT).show()
            return
        }

        Log.d("MainActivity", "username is: $username")
        Log.d("MainActivity", "email is: $email" )
        Log.d("MainActivity", "pass is:   $pass")

        //Firebase
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
            //we check if the actual creation was succesfull
            .addOnCompleteListener{
                if(!it.isSuccessful) return@addOnCompleteListener
                //else if successfull
                Log.d("Main", "Successfully created user with uid: ${it.result?.user?.uid}")
            }
            .addOnFailureListener{
                Log.d("Main", "Failed to create user:${it.message}")
                Toast.makeText(this, "Failed to create user:${it.message}", Toast
                    .LENGTH_SHORT).show()
            }
    }
}