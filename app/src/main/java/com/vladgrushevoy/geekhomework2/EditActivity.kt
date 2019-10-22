package com.vladgrushevoy.geekhomework2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        getData()
        ok_but.setOnClickListener {
            val from = from_edit.text.toString().toInt()
            val to= to_edit.text.toString().toInt()
            if(from < to) {
                setResult(
                    Activity.RESULT_OK,
                    Intent().apply {
                        putExtra("from_refactored", from_edit.text.toString())
                        putExtra("to_refactored", to_edit.text.toString())
                    })
                finish()
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun getData() {
        intent.apply {
            from_edit.setText(getStringExtra("From"))
            to_edit.setText(getStringExtra("to"))
        }
    }
}
