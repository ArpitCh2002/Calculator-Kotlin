package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import androidx.core.util.lruCache
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonpercent: android.widget.Button
    lateinit var buttonclear: android.widget.Button
    lateinit var buttondot: android.widget.Button
    lateinit var buttonequal: android.widget.Button
    lateinit var buttonadd: android.widget.Button
    lateinit var buttonsub: android.widget.Button
    lateinit var buttonmultiply: android.widget.Button
    lateinit var buttondivide: android.widget.Button
    lateinit var buttonbackspace: android.widget.Button
    lateinit var inputtext: EditText
    lateinit var resulttext: EditText
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button0 = findViewById(R.id.btn_0)
        button00 = findViewById(R.id.btn_00)
        button1 = findViewById(R.id.btn_1)
        button2 = findViewById(R.id.btn_2)
        button3 = findViewById(R.id.btn_3)
        button4 = findViewById(R.id.btn_4)
        button5 = findViewById(R.id.btn_5)
        button6 = findViewById(R.id.btn_6)
        button7 = findViewById(R.id.btn_7)
        button8 = findViewById(R.id.btn_8)
        button9 = findViewById(R.id.btn_9)
        buttonpercent = findViewById(R.id.btn_percent)
        buttonclear = findViewById(R.id.clear_btn)
        buttondot = findViewById(R.id.btn_dot)
        buttonequal = findViewById(R.id.btn_equal)
        buttonadd = findViewById(R.id.btn_plus)
        buttonsub = findViewById(R.id.btn_subtract)
        buttonmultiply = findViewById(R.id.btn_multiply)
        buttondivide = findViewById(R.id.btn_divide)
        buttonbackspace = findViewById(R.id.btn_backspace)
        resulttext = findViewById(R.id.result)
        inputtext = findViewById(R.id.input_number)

        inputtext.movementMethod = ScrollingMovementMethod()
        inputtext.setActivated(true)
        inputtext.setPressed(true)

        var text: String

        button0.setOnClickListener{
            text = inputtext.text.toString() + "0"
            inputtext.setText(text)
            result(text)
        }

        button00.setOnClickListener{
            text = inputtext.text.toString() + "00"
            inputtext.setText(text)
            result(text)
        }

        buttondot.setOnClickListener{
            text = inputtext.text.toString() + "."
            inputtext.setText(text)
            result(text)
        }

        button1.setOnClickListener{
            text = inputtext.text.toString() + "1"
            inputtext.setText(text)
            result(text)
        }

        button2.setOnClickListener{
            text = inputtext.text.toString() + "2"
            inputtext.setText(text)
            result(text)
        }

        button3.setOnClickListener{
            text = inputtext.text.toString() + "3"
            inputtext.setText(text)
            result(text)
        }

        button4.setOnClickListener{
            text = inputtext.text.toString() + "4"
            inputtext.setText(text)
            result(text)
        }

        button5.setOnClickListener{
            text = inputtext.text.toString() + "5"
            inputtext.setText(text)
            result(text)
        }

        button6.setOnClickListener{
            text = inputtext.text.toString() + "6"
            inputtext.setText(text)
            result(text)
        }

        button7.setOnClickListener{
            text = inputtext.text.toString() + "7"
            inputtext.setText(text)
            result(text)
        }

        button8.setOnClickListener{
            text = inputtext.text.toString() + "8"
            inputtext.setText(text)
            result(text)
        }

        button9.setOnClickListener{
            text = inputtext.text.toString() + "9"
            inputtext.setText(text)
            result(text)
        }

        buttonadd.setOnClickListener {
            text = inputtext.text.toString() + "+"
            inputtext.setText(text)
            count = count + 1
        }

        buttonsub.setOnClickListener {
            text = inputtext.text.toString() + "-"
            inputtext.setText(text)
            count = count + 1
        }

        buttonmultiply.setOnClickListener {
            text = inputtext.text.toString() + "*"
            inputtext.setText(text)
            count = count + 1
        }

        buttondivide.setOnClickListener {
            text = inputtext.text.toString() + "/"
            inputtext.setText(text)
            count = count + 1
        }

        buttonpercent.setOnClickListener {
            text = inputtext.text.toString() + "%"
            inputtext.setText(text)
            count = count + 1
        }

        buttonequal.setOnClickListener {
            text = resulttext.text.toString()
            inputtext.setText(text)
            resulttext.setText(null)
        }

        buttonclear.setOnClickListener{
            inputtext.setText(null)
            resulttext.setText(null)
        }

        buttonbackspace.setOnClickListener{
            var Backspace: String?=null
            if (inputtext.text.length>0) {
                val stringBuilder: StringBuilder = StringBuilder(inputtext.text)
                val find = inputtext.text.toString()
                val find_2 = find.last()

                if (find_2.equals('+') || find_2.equals('-') || find_2.equals('*') || find_2.equals('/') ||
                        find_2.equals('%')) {
                    count = count - 1
                }

                stringBuilder.deleteCharAt(inputtext.text.length-1)
                Backspace = stringBuilder.toString()
                inputtext.setText(Backspace)
                result(Backspace)
            }
        }
    }

    private fun result(text: String) {
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")

        try {
            val result: Any=engine.eval(text)
            var mainr = result.toString()

            if (count == 0)  {
                resulttext.setText(null)
            }
            else {
                resulttext.setText(mainr)
            }
        }
        catch (e: ScriptException) {
            Log.d("TAG", "ERROR")
        }
    }
}

