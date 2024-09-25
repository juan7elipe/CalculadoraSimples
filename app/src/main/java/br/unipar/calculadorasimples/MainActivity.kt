package br.unipar.calculadorasimples

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputNumero = findViewById<EditText>(R.id.edNumero)
        val inputNumero2 = findViewById<EditText>(R.id.edNumero2)
        val botaoSoma = findViewById<Button>(R.id.btnSomar)
        val botaoSub = findViewById<Button>(R.id.btnSub)
        val resultadoSoma = findViewById<TextView>(R.id.txtResultadoSoma)
        val resultadoSub = findViewById<TextView>(R.id.txtResultadoSub)

        botaoSoma.setOnClickListener {
            // Pega o valor do input da tela
            val numeroInformado1 = inputNumero.text.toString()
            val numeroInformado2 = inputNumero2.text.toString()


            val num1 = numeroInformado1.toDoubleOrNull()
            val num2 = numeroInformado2.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val soma = num1 + num2

                resultadoSoma.text = "Resultado da soma: $soma"
            } else {
                resultadoSoma.text = "Por favor, insira valores válidos."
            }
        }

        botaoSub.setOnClickListener {
            // Pega o valor do input da tela
            val numeroInformado1 = inputNumero.text.toString()
            val numeroInformado2 = inputNumero2.text.toString()

            val num1 = numeroInformado1.toDoubleOrNull()
            val num2 = numeroInformado2.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val sub = num1 - num2

                resultadoSub.text = "Resultado da subtração: $sub"
            } else {
                resultadoSub.text = "Por favor, insira valores válidos."
            }
        }
    }
}