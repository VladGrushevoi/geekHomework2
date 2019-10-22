package com.vladgrushevoy.geekhomework2

import android.content.Intent
import android.content.Intent.*
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_but.setOnClickListener {
            startActivityForResult(Intent(this, EditActivity::class.java).apply {
                putExtra("From", From.text)
                putExtra("to", to.text)
            }, 1)
        }
        sendEmail()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                From.text = data.getStringExtra("from_refactored")
                to.text = data.getStringExtra("to_refactored")
            }
        }
    }

    fun randomNumber() {

        val fromString = From.text.toString()
        val from = Integer.parseInt(fromString)
        val toString = to.text.toString()
        val to = Integer.parseInt(toString)

        val randomValue = Random.nextInt(from,to)
        viewRandom.text = randomValue.toString()
    }

    fun sendEmail(){
        send.setOnClickListener {
            val title = "Random number"
            val text = "Your number is ${viewRandom.text}"
            startActivity(Intent(ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(EXTRA_SUBJECT, title)
                putExtra(EXTRA_TEXT, text)
            })
        }
    }
}
