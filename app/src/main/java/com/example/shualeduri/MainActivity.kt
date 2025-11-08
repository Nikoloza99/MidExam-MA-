package com.example.shualeduri

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.startShoppingBTN)
        button.setOnClickListener {
            val intent = Intent(this,product::class.java)
            startActivity(intent)
        }
    }
}
