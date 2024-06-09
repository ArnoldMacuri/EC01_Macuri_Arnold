package pe.edu.idat.ec1

import androidx.compose.runtime.Composable

//EJERCICIO 2
@Composable
private fun operacion(num1: Int, num2: Int): Int{
    return when{
        num1 == num2 -> num1 * num2
        num1 > num2 -> num1 - num2
        else -> num1 + num2
    }
}

fun main() {
    print("Ingrese el primer número: ")
    val num1 = readln().toInt()
    print("Ingrese el segundo número: ")
    val num2 = readln().toInt()

    val resultado = operacion(num1, num2)
    println("El resultado es: $resultado")
}

