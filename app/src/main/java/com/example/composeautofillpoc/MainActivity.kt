package com.example.composeautofillpoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composeautofillpoc.ui.theme.ComposeAutofillPOCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAutofillPOCTheme {
                NavGraph()
            }
        }
    }
}