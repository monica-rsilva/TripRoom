package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SingupScreen()
                }
            }
        }
    }
}

@Composable
fun SingupScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End) {
            Card(modifier = Modifier
                .width(120.dp)
                .height(40.dp),
                shape = RoundedCornerShape(bottomStart = 16.dp),
                backgroundColor =  Color(206,1,240)
            ) {
                
            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.button_sign_up),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(204,6,246)
            )
            Text(text = stringResource(id = R.string.text_create),
            fontSize = 14.sp, color = Color(160,156,156)
            )
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "", onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.user_name ))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.person_24),
                        contentDescription = stringResource(id = R.string.email_description),
                        tint = Color(207,6,240)
                    )
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "", onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.phone ))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.android_24),
                        contentDescription = stringResource(id = R.string.phone_description),
                        tint = Color(207,6,240)
                    )
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

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
                }
            )

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
                        painter = painterResource(id = R.drawable.lock_24),
                        contentDescription = stringResource(id = R.string.password_description),
                        tint = Color(207,6,240)
                    )
                }
            )

//            Checkbox(checked = true, onCheckedChange = )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    TripRoomTheme {
        SingupScreen()
    }
}