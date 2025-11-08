package com.example.shualeduri

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class my_cart : AppCompatActivity() {

    var quantity = 2
    val pricePerItem = 120.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.my_cart)

        val subtotalTextPart1 = findViewById<TextView>(R.id.subtotalTextPart1)
        val subtotalText = findViewById<TextView>(R.id.SubtotalText)
        val subtotalTextPart2 = findViewById<TextView>(R.id.subtotalTextPart2)
        val totalTextView = findViewById<TextView>(R.id.TotalAmount)
        val quantityTextView = findViewById<TextView>(R.id.ItemQuantity)

        quantityTextView.text = quantity.toString()
        totalTextView.text = "$${pricePerItem * quantity}"
        subtotalText.text = quantity.toString()
        subtotalTextPart1.text = "Subtotal ("
        subtotalTextPart2.text = " items)"

        val minusButton = findViewById<ImageButton>(R.id.minusBTN)
        minusButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                quantityTextView.text = quantity.toString()
                totalTextView.text = "$${pricePerItem * quantity}"
                subtotalText.text = quantity.toString()
            }
        }


        val plusButton = findViewById<ImageButton>(R.id.plusBTN)
        plusButton.setOnClickListener {
            quantity++
            quantityTextView.text = quantity.toString()
            totalTextView.text = "$${pricePerItem * quantity}"
            subtotalText.text = quantity.toString()
        }

        val itemPrice = intent.getDoubleExtra("ItemPrice", 0.0)
        findViewById<TextView>(R.id.ItemAmount).text = "$${itemPrice}"

        val backArrowButton = findViewById<ImageButton>(R.id.BackArrowBTN)
        backArrowButton.setOnClickListener {
            finish()
        }
        val placeOrderButton = findViewById<Button>(R.id.PlaceOrderBTN)
        placeOrderButton.setOnClickListener {
            val intent = Intent(this, successfuly_pop::class.java)
            startActivity(intent)
        }
    }
}