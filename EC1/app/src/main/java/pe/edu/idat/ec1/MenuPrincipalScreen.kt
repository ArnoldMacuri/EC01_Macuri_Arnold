package pe.edu.idat.ec1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun menuPrincipal(){
    var seleccionarProblema by rememberSaveable {
        mutableStateOf(1)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.padding(top = 50.dp))
        Text(text = "Selecciona un ejercicio:", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Button(onClick = {seleccionarProblema = 1}) {
                Text(text = "Ejercicio 1")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {seleccionarProblema = 2}) {
                Text(text = "Ejercicio 2" )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {seleccionarProblema = 3}) {
                Text(text = "Ejercicio 3" )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {seleccionarProblema = 4}) {
                Text(text = "Ejercicio 4" )
            }
        }
        Spacer(modifier = Modifier.padding(bottom = 50.dp))
        Spacer(modifier = Modifier.height(16.dp))
        when (seleccionarProblema){
            1 -> Ejercicio1Screen()
            2 -> Ejercicio2Screen()
            3 -> Ejercicio3Screen()

        }
    }
}

@Composable
fun Ejercicio1Screen(){
    var indicador by remember{ mutableStateOf("") }
    var tasa by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf<String?>(null) }
    val tasasMaxima = mapOf(
        "C" to 0.3,
        "A" to 0.3,
        "T" to 0.5,
        "M" to 0.3
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Control de Alcoholemia", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = indicador, onValueChange = {indicador = it},
            label = { Text("Indicador de Vehículo") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = tasa, onValueChange = { tasa = it },
            label = { Text("Tasa de Alcohol") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val tasaAlcohol = tasa.toDoubleOrNull()
            val tasaMaxima = tasasMaxima[indicador.uppercase()]
            resultado = if (tasaAlcohol !=null && tasaMaxima != null){
                if (tasaAlcohol > tasaMaxima){
                    "Positivo en el control de alcohomelia"
                }else{
                    "Negativo en el control de alcohomelia"
                }
            }else{
                "Lo ingresado esta incorrecto"
            }
        }) {
            Text(text = "Verificar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        resultado?.let { 
            Text(text = "Resultado: $it")
        }
    }
}

@Composable
fun Ejercicio2Screen(){
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf<String?>(null) }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Multiplica, resta y suma", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = num1, onValueChange = { num1 = it },
            label = {Text(text = "Número 1")})
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = num2, onValueChange = {num2 = it},
            label = { Text(text = "Numero 2")})
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val n1 = num1.toIntOrNull()
            val n2 = num2.toIntOrNull()
            resultado = if (n1 !=null && n2 != null){
                when{
                    n1 == n2 -> (n1 * n2).toString()
                    n1 > n2 -> (n1 - n2).toString()
                    else -> (n1 + n2).toString()
                }
            }else {
                "Lo ingresado esta incorrecto"
            }
        }) {
            Text(text = "Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))
        resultado?.let {
            Text(text = "Resultado: $it")
        }
    }
}

@Composable
fun Ejercicio3Screen(){
    var numeroMes by remember { mutableStateOf("") }
    var mes by remember { mutableStateOf<String?>(null) }

    val meses = listOf(
        "Enero","Febrero","Marzo","Abril","Mayo","Junio",
        "Julio","Agosto","Septiembre","Octubre","Nomviembre","Diciembre"
    )
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Meses del Año", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = numeroMes, onValueChange = {numeroMes = it}, label = { Text(text = "Número del mes")} )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val mesNumero = numeroMes.toIntOrNull()
            mes = if (mesNumero != null && mesNumero in 1..12){
                meses[mesNumero - 1]
            }else{
                "Número de mes incorrecto"
            }
        }) {
            Text(text = "Obtener Mes")
        }
        Spacer(modifier = Modifier.height(16.dp))
        mes?.let{
            Text(text = "Mes: $it")
        }
    }
}

