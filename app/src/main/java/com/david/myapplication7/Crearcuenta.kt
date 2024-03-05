package com.david.myapplication7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Crearcuenta : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitycuenta)
        val txtnombre : TextView = findViewById(R.id.nombre)
        val txtemail_nuevo : TextView = findViewById(R.id.email)
        val txtpass1 : TextView = findViewById(R.id.pass)
        val txtpass2 : TextView = findViewById(R.id.pass2)
        val btncrearc: Button = findViewById(R.id.btncrearr)
        btncrearc.setOnClickListener()
        {
            val pass1 = txtpass1.text.toString()
            val pass2 = txtpass2.text.toString()
            if (pass1.equals(pass2))
            {
                createAccount(txtemail_nuevo.text.toString(), txtpass1.text.toString())
            }
            else
            {
                Toast.makeText(baseContext, "No son compatibles", Toast.LENGTH_SHORT).show()
                txtpass1.requestFocus()
            }
        }
        firebaseAuth= Firebase.auth
    }

    private fun createAccount(email: String, password: String)
    {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->
            if (task.isSuccessful)
            {
                Toast.makeText(baseContext, "Cuenta Registrada", Toast.LENGTH_SHORT).show()

            }
            else
            {
                Toast.makeText(baseContext, "Error en los datos" + task.exception, Toast.LENGTH_SHORT).show()
            }
        }
    }
}