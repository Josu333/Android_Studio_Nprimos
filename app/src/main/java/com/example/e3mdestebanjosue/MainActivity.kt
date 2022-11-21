package com.example.e3mdestebanjosue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.e3mdestebanjosue.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    val listaPrimos = mutableListOf(2)
    var numEntrada = 0 //limite superior
    var limiteInferior=2
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDevolver.setOnClickListener { enesimo() }

    }

    /**
     * Determina si un numero es o no primo
     */
    fun esPrimo(numero:Int): Boolean {
        var primo = true

        for (i in limiteInferior..numero/2) {

            if (numero % i == 0) {
                primo = false

                break
            }

        }
        return primo
    }

    fun enesimo() {

        var contador = 2

        try {
            numEntrada = binding.entradaNum.text.toString().toInt()//indice a buscar

            //mira si está ya calculado
            if(numEntrada.toString().toInt()<=listaPrimos.size){
               mostarNprimo()

            }else{//caso de que no esté calculado

                //Calcula los primos hasta que la lista alcanza N longitud
                while (listaPrimos.size < numEntrada){

                    if(esPrimo(contador)){
                        guardar(contador)
                    }
                    contador++
                }
                mostarNprimo()

            }


        } catch (errorEntrada: Exception) {
            errorEntrada.printStackTrace()
            val snackbar1 = Snackbar.make(
                binding.main, "Se debe introducuir un número entero",
                Snackbar.LENGTH_SHORT
            ).show()
            binding.salidaNum.text="Error"

        }

    }


    /*
    * Guarda el numero primo si no esta ya en el set (colección)
    */
    fun guardar(numero: Int) {
        if (!listaPrimos.contains(numero))
            listaPrimos.add(numero)
    }

    /*
    * Método para mostrar el número de la lista no calculado
    * */
    fun mostarNprimo() {
        binding.salidaNum.text = listaPrimos[numEntrada-1].toString()
    }
}





