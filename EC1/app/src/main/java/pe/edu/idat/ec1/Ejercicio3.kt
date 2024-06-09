package pe.edu.idat.ec1

//EJERCICIO 3
private fun obtenerMes(numero: Int): String{
    val meses = listOf(
        "Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
        "Agosto","Septiembre","Octubre","Noviembre","Diciembre"
    )
    return if (numero in 1..12){
        meses[numero - 1]
    }else{
        "Numero de mes no existe"
    }
}

fun main() {
    print("Ingresa un número del 1 al 12 para obtener el nombre de un mes: ")
    val numeroMes = readln().toInt()
    val mes = obtenerMes(numeroMes)
    println("El mes es: $mes")
}