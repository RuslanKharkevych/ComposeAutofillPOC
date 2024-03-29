package com.example.composeautofillpoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.composeautofillpoc.ui.theme.ComposeAutofillPOCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAutofillPOCTheme {
                Surface {
                    NavGraph()
                }
            }
        }
    }
}