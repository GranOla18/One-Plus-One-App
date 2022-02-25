package com.example.oneplusoneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private val TAG = "MainActivity"
private val TEXT = "TEXT_CONTENT"

private var textViewResult: TextView? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput1: EditText = findViewById<EditText>(R.id.Input1)
        val userInput2: EditText = findViewById<EditText>(R.id.Input2)
        val userInput3: EditText = findViewById<EditText>(R.id.Input3)
        textViewResult = findViewById<TextView>(R.id.Resultado)

        val buttonAdd: Button = findViewById<Button>(R.id.button_agregar)
        val buttonClean: Button = findViewById<Button>(R.id.button_limpiar)

        textViewResult?.text = ""

        textViewResult?.movementMethod = ScrollingMovementMethod()

        buttonAdd?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick Add")
                if(userInput1.text.isBlank() or userInput2.text.isBlank() or userInput3.text.isBlank()) {
                    Log.d(TAG, "Some input is empty")
                }
                else {
                    textViewResult?.append(userInput1.text)
                    textViewResult?.append(" + ")
                    textViewResult?.append(userInput2.text)
                    textViewResult?.append(" = ")
                    textViewResult?.append(userInput3.text)
                    textViewResult?.append("\n")

                    userInput1.text.clear()
                    userInput2.text.clear()
                    userInput3.text.clear()
                }
            }
        })

        buttonClean?.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick Clean")
                textViewResult?.setText("")
                userInput1.text.clear()
                userInput2.text.clear()
                userInput3.text.clear()
            }
        })

    }
}