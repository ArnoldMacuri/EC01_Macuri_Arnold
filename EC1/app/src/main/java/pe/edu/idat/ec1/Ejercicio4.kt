package pe.edu.idat.ec1

fun sumaDigitos(numero: Int): Int{
    var suma = 0
    var num = numero
    while (num > 0){
        suma += num % 10
        num /= 10
    }
    return suma
}

fun main() {
    for (numero in 23..99){
        println("La suma de los digitos del número $numero es: ${sumaDigitos(numero)}" )
    }
}