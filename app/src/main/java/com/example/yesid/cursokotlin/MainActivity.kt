package com.example.yesid.cursokotlin

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numUser: Int = 1
    private var matrixPlayer = Array(3, { IntArray(3) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { click (it)}
        btn2.setOnClickListener { click (it)}
        btn3.setOnClickListener { click (it)}
        btn4.setOnClickListener { click (it)}
        btn5.setOnClickListener { click (it)}
        btn6.setOnClickListener { click (it)}
        btn7.setOnClickListener { click (it)}
        btn8.setOnClickListener { click (it)}
        btn9.setOnClickListener { click (it)}

    }

    protected fun fillmatrix(idButton: Int, NumUsuario: Int) {

        if (idButton == btn1.id) {
            matrixPlayer[0][0] = NumUsuario
        }
    }

    private fun validateRow() {
        var cont = 0

    }

    private fun validateRows() {

        var cont = 0

        for (colArray in matrixPlayer) {
            for (rowValue in colArray) {
                if (rowValue == 1) {
                    cont++
                }
            }
        }

        if (cont == 3) {
            // gano el jugador 1
            return
        }

        for (colArray in matrixPlayer) {
            for (rowValue in colArray) {
                if (rowValue == 2) {
                    cont++
                }
            }
        }

        if (cont == 3) {
            // gano el jugador 2
        }


    }

    fun Button.enable(){
        this.isEnabled=true
    }
    fun Button.disable(){
        this.isEnabled=true
    }
    fun Button.clear(){
        this.text=""
    }

    private fun resetGame() {
        btn1.enable()
        btn2.enable()
        btn3.enable()
        btn4.enable()
        btn5.enable()
        btn6.enable()
        btn7.enable()
        btn8.enable()
        btn9.enable()

    }

    private val click: (View) -> Unit = {

        val button = it as Button

        if (numUser == 1) {
            button.text = "O"
            numUser = 2
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                button.setTextColor(getColor(R.color.colorblanco))
            }
        } else if (numUser == 2) {
            button.text = "X"
            numUser = 1
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                button.setTextColor(getColor(R.color.colorAccent))
            }
        }
        button.isEnabled

    }

    inner class ClicButton : View.OnClickListener {

        override fun onClick(v: View?) {


        }


    }
}
