package com.example.calculoaposentaria

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculoaposentaria.ui.theme.CalculoAposentariaTheme
import	android.widget.Button
import	android.widget.EditText
import	android.widget.Spinner
import	android.widget.TextView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        val txt_idade = findViewById<EditText>(R.id.txt_idade)

        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino")
        )

        findViewById<Button>(R.id.btn_calcular).setOnClickListener {

            val sexo = spn_sexo.selectedItem as String
            val idade = txt_idade.text.toString().toIntOrNull() ?: 0
            var resultado = 0

            if (sexo == "Masculino") {
                resultado = 65 - idade
            } else {
                resultado = 60 - idade
            }

            txt_resultado.text = "Faltam $resultado	anos para você se aposentar."
        }
    }
}