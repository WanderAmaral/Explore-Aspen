package com.exploreaspen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.exploreaspen.ui.screen.signin.SignInScreen
import com.exploreaspen.ui.screen.signup.SignUpScreen
import com.exploreaspen.ui.screen.splash.SplashScreen
import com.exploreaspen.ui.states.SignUpUiState
import com.exploreaspen.ui.theme.ExploreAspenTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jakewharton.threetenabp.AndroidThreeTen
import kotlinx.coroutines.flow.callbackFlow
import np.com.bimalkafle.firebaseauthdemoapp.AuthViewModel
import java.util.concurrent.Flow

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(this)

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
        val authViewModel: AuthViewModel by viewModels()
        setContent {
            ExploreAspenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyAppNavigation(
                        modifier = Modifier.padding(innerPadding),
                        authViewModel = authViewModel
                    )
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ExploreAspenTheme {
//
//    }
//
//}

