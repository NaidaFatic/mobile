package com.example.myapplication.ui.screen

import android.content.Context
import android.util.Patterns.EMAIL_ADDRESS
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.sendNotification

@Composable
fun RegistrationScreen(context: Context){
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var checkPassword by remember { mutableStateOf(true) }
    var checkEmail by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .padding(vertical = 50.dp)
            .verticalScroll(
                rememberScrollState()
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.launch_icon),
            contentDescription = "",
            modifier = Modifier.size(width = 100.dp, height = 100.dp)
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Blue
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            enabled = true,
            label = {
                Text(text = "name")
            },
            placeholder = {
                Text(text = "name")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next)

        )


        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        TextField(
            value = surname,
            onValueChange = { surname = it },
            enabled = true,
            label = {
                Text(text = "surname")
            },
            placeholder = {
                Text(text = "surname")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            enabled = true,
            label = {
                Text(text = "email")
            },
            placeholder = {
                Text(text = "example@exmaple.com")
            },
            isError = checkEmail,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next)
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        TextField(
            value = password,
            onValueChange = { password = it},
            label = {
                Text(text = "password")
            },
            visualTransformation = if(showPassword){
                VisualTransformation.None
            }
            else{
                PasswordVisualTransformation()
                },
            isError = !checkPassword,
            trailingIcon = {  Icon(
                painter = if(showPassword){
                    painterResource(id = R.drawable.baseline_visibility_24)
                }
                else{
                    painterResource(id = R.drawable.baseline_visibility_off_24)
                },
                contentDescription = "",
                modifier = Modifier.clickable(onClick = {showPassword = !showPassword }))
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next)
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        TextField(
            value = passwordRepeat,
            onValueChange = { passwordRepeat = it},
            label = {
                Text(text = "repeat password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = !checkPassword,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 5.dp))

        TextButton(
            onClick = {
                sendNotification("this is title of notification", "body of notification", 1, context)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Have an account?")
        }

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        Button(onClick = {
            checkPassword = password == passwordRepeat;
            checkEmail = !checkEmail(email)
        }) {
            Text(
                text = "Registration",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 0.dp)
            )
        }
    }
}

fun checkEmail(email: String): Boolean{
    return  EMAIL_ADDRESS.matcher(email).matches()
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview(){
    //RegistrationScreen()
}