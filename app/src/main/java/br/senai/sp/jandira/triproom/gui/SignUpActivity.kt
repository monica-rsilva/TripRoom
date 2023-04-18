package br.senai.sp.jandira.triproom.gui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
//import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
//import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.components.BottomShape
import br.senai.sp.jandira.triproom.model.User
import br.senai.sp.jandira.triproom.repository.UserRepository
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

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
                    SingUpScreen()
                }
            }
        }
    }
}

@Composable
fun SingUpScreen() {

    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }
//para pegar o caminho do arquivo(uri) -> (ex: imagem,musica,documento...etc )
    var launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        ) {
        photoUri = it
    }
//para pegar a imagem de fato
    var painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(photoUri)
                .build()
        )

    var userNameState by remember {
        mutableStateOf("")
    }

    var phoneUserState by remember {
        mutableStateOf("")
    }

    var emailUserState by remember {
        mutableStateOf("")
    }

    var passWordState by remember {
        mutableStateOf("")
    }

    var over18State by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(bottomStart = 16.dp),
                backgroundColor = Color(206, 1, 240)
            ) {

            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.button_sign_up),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(204, 6, 246)
            )
            Text(
                text = stringResource(id = R.string.text_create),
                fontSize = 14.sp, color = Color(160, 156, 156)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier.size(100.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = 0.dp, y = 0.dp),
                    shape = CircleShape,
                    backgroundColor = Color(232, 232, 232, 255)
                ) {
                    Image(
                        painter = if(photoUri == null ) painterResource(id = R.drawable.profile) else painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.photo_24),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clickable {
                            launcher.launch("image/*")
                            var message = "nada"
                            Log.i("ds2m", "${photoUri?.path ?: message}")
                        }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .height(405.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                OutlinedTextField(
                    value = userNameState, onValueChange = { userNameState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = {
                        Text(text = stringResource(id = R.string.user_name))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.person_24),
                            contentDescription = stringResource(id = R.string.email_description),
                            tint = Color(207, 6, 240)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = phoneUserState, onValueChange = { phoneUserState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    label = {
                        Text(text = stringResource(id = R.string.phone))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.android_24),
                            contentDescription = stringResource(id = R.string.phone_description),
                            tint = Color(207, 6, 240)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = emailUserState, onValueChange = { emailUserState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    label = {
                        Text(text = stringResource(id = R.string.email_label))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email_24),
                            contentDescription = stringResource(id = R.string.email_description),
                            tint = Color(207, 6, 240)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = passWordState, onValueChange = { passWordState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    label = {
                        Text(text = stringResource(id = R.string.password_label))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock_24),
                            contentDescription = stringResource(id = R.string.password_description),
                            tint = Color(207, 6, 240)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = over18State,
                        onCheckedChange = {
                            over18State = it
                        }
                    )
                    Text(text = stringResource(id = R.string.over_18))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        saveUser(
                            userNameState,
                            phoneUserState,
                            emailUserState,
                            passWordState,
                            over18State,
                            photoUri?.path ?: "",
                            context
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 246))
                ) {
                    Text(
                        text = "CREATE ACCOUNT",
                        modifier = Modifier.padding(4.dp),
                        color = Color.White
                    )
                }
            }

        }
        Row(modifier = Modifier.fillMaxWidth()) {
            BottomShape()
        }
    }

}

fun saveUser(
    userName: String,
    phone: String,
    email: String,
    password: String,
    isOver18: Boolean,
    profilePhotoUri: String,
    context: Context
) {
//    criando um objeto user
    val newUser = User(
        id = 0,
        userName = userName,
        phone = phone,
        email = email,
        password = password,
        isOver18 = isOver18,
        profilePhoto = profilePhotoUri
    )
//    criando uma instancia do repositorio
    val userRepository = UserRepository(context)

//    verificar se o usuario ja existe

    val user = userRepository.findUserByEmail(email)
    Log.i("ds3m", "${user.toString()}")

//    Salvar o usuario

    if(user == null){
        val id = userRepository.save(newUser)

        Toast.makeText(
            context,
            "Created User #$id",
            Toast.LENGTH_LONG
        ).show()
    } else {
        Toast.makeText(
            context,
            "User already exists!",
            Toast.LENGTH_LONG
        ).show()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    TripRoomTheme {
        SingUpScreen()
    }
}