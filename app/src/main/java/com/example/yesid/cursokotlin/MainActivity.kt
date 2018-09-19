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

        btn1.setOnClickListener { click(it) }
        btn2.setOnClickListener { click(it) }
        btn3.setOnClickListener { click(it) }
        btn4.setOnClickListener { click(it) }
        btn5.setOnClickListener { click(it) }
        btn6.setOnClickListener { click(it) }
        btn7.setOnClickListener { click(it) }
        btn8.setOnClickListener { click(it) }
        btn9.setOnClickListener { click(it) }

        Btn_reiniciar.setOnClickListener { resetGame() }

    }

    protected fun fillmatrix(idButton: Int, NumUsuario: Int) {

        if (idButton == btn1.id) {
            matrixPlayer[0][0] = NumUsuario
        }
        if (idButton == btn2.id) {
            matrixPlayer[0][1] = NumUsuario
        }

        if (idButton == btn3.id) {
            matrixPlayer[0][2] = NumUsuario
        }

        if (idButton == btn4.id) {
            matrixPlayer[1][0] = NumUsuario
        }

        if (idButton == btn5.id) {
            matrixPlayer[1][1] = NumUsuario
        }

        if (idButton == btn6.id) {
            matrixPlayer[1][2] = NumUsuario
        }

        if (idButton == btn7.id) {
            matrixPlayer[2][0] = NumUsuario
        }

        if (idButton == btn8.id) {
            matrixPlayer[2][1] = NumUsuario
        }

        if (idButton == btn9.id) {
            matrixPlayer[2][2] = NumUsuario
        }
    }


    private fun validateRows(numUser: Int): Boolean {
        var win = false

        for (row in 0 until matrixPlayer.size) {
            for (col in 0 until matrixPlayer.size) {
                if (matrixPlayer[row][col] != this.numUser) {
                    win = false
                    break
                } else {
                    win = true
                }
            }
            if (win) {
                break
            }
        }

        return win

    }

    private fun validateColumns(numUser: Int): Boolean {
        var win = false

        for (col in 0 until matrixPlayer.size) {
            for (row in 0 until matrixPlayer.size) {
                if (matrixPlayer[row][col] != this.numUser) {
                    win = false
                    break
                } else {
                    win = true
                }
            }
            if (win) {
                break
            }
        }

        return win

    }

    private fun validateDiagonals(numUser: Int): Boolean {

        var win = false

        for (row in 0 until matrixPlayer.size) {
            for (col in 0 until matrixPlayer.size) {
                if (row == col) {
                    win = matrixPlayer[row][col] == numUser
                    break
                }
            }

            if (!win) {
                break
            }
        }

        return win

    }

    private fun validateDiagonalsInverse(numUser: Int): Boolean {

        var win = false
        var col = 2

        for (row in 0 until matrixPlayer.size) {
            win = matrixPlayer[row][col] == numUser
            if (!win) {
                break
            }
            col--
        }

        return win

    }

    private fun validateWinner(numUser: Int) {

        var win : Boolean = validateRows(numUser)

        if (win){
            lblGanador.text= winMsg(numUser)
            return
        }

        win  = validateColumns(numUser)

        if (win){
            lblGanador.text= winMsg(numUser)
            return
        }

        win = validateDiagonals(numUser)

        if (win) {
            lblGanador.text = winMsg(numUser)
        }

        win = validateDiagonalsInverse(numUser)

        if (win) {
            lblGanador.text = winMsg(numUser)
        }
    }

    private val winMsg:(Int)-> String = {
        "El ganador es el jugador $it"
    }


    fun Button.enable() {
        this.isEnabled = true
    }

    fun Button.disable() {
        this.isEnabled = false
    }

    fun Button.clear() {
        this.text = ""
    }

    private fun resetGame() {
        for (row in 0 until matrixPlayer.size) {
            for (col in 0 until matrixPlayer.size) {
                matrixPlayer[row][col] = 0

            }

        }

        btn1.enable()
        btn2.enable()
        btn3.enable()
        btn4.enable()
        btn5.enable()
        btn6.enable()
        btn7.enable()
        btn8.enable()
        btn9.enable()

        btn1.clear()
        btn2.clear()
        btn3.clear()
        btn4.clear()
        btn5.clear()
        btn6.clear()
        btn7.clear()
        btn8.clear()
        btn9.clear()

        numUser = 1
        lblGanador.text=""

    }

    private val click: (View) -> Unit = {

        val button = it as Button

        fillmatrix(button.id, numUser)
        validateWinner(numUser)

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
        button.disable()

    }


}
