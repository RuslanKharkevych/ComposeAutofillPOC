package com.example.composeautofillpoc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpPasswordView(
    onSignedUp: () -> Unit,
    onBack: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    var password by remember { mutableStateOf("") }
    var passwordMasked by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.autofill(
                autofillTypes = listOf(AutofillType.NewPassword),
                onFill = { password = it }
            ),
            label = { Text("Password") },
            value = password,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            trailingIcon = {
                IconButton(onClick = { passwordMasked = !passwordMasked }) {
                    Icon(
                        imageVector = if (passwordMasked) {
                            Icons.Default.Visibility
                        } else {
                            Icons.Default.VisibilityOff
                        },
                        contentDescription = if (passwordMasked) {
                            "Show password"
                        } else {
                            "Hide password"
                        }
                    )
                }
            },
            visualTransformation = if (passwordMasked) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            onValueChange = { password = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onSignedUp) {
            Text("Sign up")
        }
        Button(onClick =  onBack) {
            Text(text = "Back")
        }
    }
}