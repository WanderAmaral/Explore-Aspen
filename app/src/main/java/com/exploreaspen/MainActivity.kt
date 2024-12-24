package com.exploreaspen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.exploreaspen.ui.screen.signin.SignInScreen
import com.exploreaspen.ui.screen.splash.SplashScreen
import com.exploreaspen.ui.theme.ExploreAspenTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = Firebase.auth
        Log.i(TAG, "onCreate: ${auth.currentUser}")

//        auth.createUserWithEmailAndPassword("wanderamaral@gmail.com", "12345678")
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    Log.i(TAG, "create user: sucesso")
//                } else {
//                    Log.i(TAG, "create user: falha ${task.exception}")
//                }
//            }
//        auth.signInWithEmailAndPassword("wanderamaral@gmail.com", "12345678")

//        auth.signOut()


        enableEdgeToEdge()
        setContent {
            ExploreAspenTheme {
                SignInScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExploreAspenTheme {

    }

}