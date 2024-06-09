package pe.edu.idat.ec1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.idat.ec1.ui.theme.EC1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EC1Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){
                    menuPrincipal()
                }

            }
        }
    }
}
@Composable
fun menuPrincipal(){
    var seleccionarProblema by remember { mutableStateOf(1)}
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Selecciona un ejercicio:", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Row {
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
            Spacer(modifier = Modifier.height(16.dp))
            when (seleccionarProblema){

            }
    }
}

@Composable
fun Ejercicio1(){
    var indicador by remember { mutableStateOf("") }
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
        Text(text = "Control de Alcoholemia", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = indicador, onValueChange = {newValue -> indicador = newValue},
            label = { Text(text = "Indicador de Vehiculo")})
    }
}
