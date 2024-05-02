package shpp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import shpp.android.ui.theme.AndroidCourseTheme
import shpp.android.ui.theme.DarkBlue
import shpp.android.utils.constants.ContentDescription

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge() // might want to revert to this and use Scaffold
        setContent {
            AndroidCourseTheme {
                BackgroundColumn(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun BackgroundColumn(modifier: Modifier = Modifier) {
    Column {
        ProfileColumn(modifier = modifier.weight(1f))
        SettingsColumn(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ProfileColumn(modifier: Modifier) {
    Column(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.profileSettingsButton),
                color = Color.White,
                fontSize = 24.sp
            )
            OutlinedButton(border = BorderStroke(
                width = 2.dp, color = MaterialTheme.colorScheme.onSecondary
            ), shape = RoundedCornerShape(6.dp), onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(R.string.profileLogoutButton),
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = 14.sp,
                )
            }
        }
        AsyncImage(
            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlFaAvDX_Hej3RM0IbhlzDTzNxrDXNOZk6w7tr9IX367CZsvLXa4ZyBVxQ-r4kD4MTf4M&usqp=CAU",
            contentDescription = ContentDescription.profileImage,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(113.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Kostyan", color = MaterialTheme.colorScheme.onPrimary, fontSize = 18.sp
        ) // todo remove hardcode
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "career", color = MaterialTheme.colorScheme.onSecondary, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "address", color = MaterialTheme.colorScheme.onSecondary, fontSize = 14.sp)
    }
}

@Composable
fun SettingsColumn(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.padding(top = 62.dp)) {
            SocialNetworkImage(
                resourceId = R.drawable.ic_facebook,
                contentDescription = ContentDescription.profileFacebookIcon
            )
            Spacer(modifier = Modifier.width(32.dp))
            SocialNetworkImage(
                resourceId = R.drawable.ic_linkedin,
                contentDescription = ContentDescription.profileLinkedInIcon
            )
            Spacer(modifier = Modifier.width(32.dp))
            SocialNetworkImage(
                resourceId = R.drawable.ic_instagram,
                contentDescription = ContentDescription.profileInstagramIcon
            )
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ },
                border = BorderStroke(width = 2.dp, color = Color.Black),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(
                    text = stringResource(R.string.profileEditProfileButton),
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(
                    text = stringResource(R.string.profileViewContactsButton),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight(600)
                )
            }
        }
    }
}

@Composable
fun SocialNetworkImage(resourceId: Int, contentDescription: String) {
    Image(
        painter = painterResource(id = resourceId), contentDescription = contentDescription
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidCourseTheme {
        BackgroundColumn(
            modifier = Modifier
                .background(DarkBlue)
                .fillMaxSize()
        )
    }
}