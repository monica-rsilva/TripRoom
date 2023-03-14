package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class MainActivity : ComponentActivity() {

    lateinit var context = LocalContext.current
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    //Column principal
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        //inicio da row da forma
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Card(modifier = Modifier
                .width(120.dp)
                .height(40.dp), shape = RoundedCornerShape(bottomStart = 16.dp),
            backgroundColor = Color(207,6,240)
            ) {

            }
        } // fim da row da forma
        // inicio da column do login
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(207,1,240)
            )
            Text(
                text = stringResource(id = R.string.message_login),
                fontSize = 14.sp,
                color = Color(160,156,156)
            )
        } //fim da column de login
        // inicio da column do form
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            OutlinedTextField(
                value = "", onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.email_label))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.email_24),
                        contentDescription = stringResource(id = R.string.email_description),
                        tint = Color(207,6,240)
                    )
            })

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "", onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.password_label))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.email_24),
                        contentDescription = stringResource(id = R.string.password_description),
                        tint = Color(207,6,240)
                    )
                })
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(207,6,246)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row() {
                Text(text = stringResource(id = R.string.button_sign_in).uppercase(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward_24),
                    contentDescription =  "",
                    tint = Color.White)

            }
        } // fim da column formulario
        // inicio da row dont have account
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.End) {
            Text(
                text = stringResource(id = R.string.dont_have),
                fontSize = 14.sp,
                color = Color(160, 156,156)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.button_sign_up),
                modifier = Modifier.clickable {

                },
                fontSize = 14.sp,
                color = Color(207, 6,246)
            )
        } // fim da row acoount
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
            Card(modifier = Modifier
                .width(120.dp)
                .height(40.dp), shape = RoundedCornerShape(topEnd = 16.dp),
                backgroundColor = Color(207,6,240)
            ) {

            }
        }
    } // fim da column principal
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TripRoomTheme {
        LoginScreen()
    }
}