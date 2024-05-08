package shpp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import shpp.android.ui.myProfile.MyProfileScreen
import shpp.android.ui.theme.AndroidCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge() // might want to revert to this and use Scaffold
        setContent {
            AndroidCourseTheme {
                MyProfileScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

