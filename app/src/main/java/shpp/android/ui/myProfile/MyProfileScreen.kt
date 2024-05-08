package shpp.android.ui.myProfile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shpp.android.R
import shpp.android.ui.common.ProfileInfoColumn
import shpp.android.ui.common.SocialNetworkRow
import shpp.android.ui.model.SocialNetworkIcon
import shpp.android.ui.theme.AndroidCourseTheme
import shpp.android.ui.theme.DarkBlue

@Composable
fun MyProfileScreen(modifier: Modifier = Modifier) {
    Column {
        ProfileHeaderColumn(modifier = modifier.weight(1f))
        SettingsColumn(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ProfileHeaderColumn(modifier: Modifier) {
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
        ProfileInfoColumn()
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
        SocialNetworkRow(
            SocialNetworkIcon(R.drawable.ic_facebook, R.string.cd_profileFacebookIcon),
            SocialNetworkIcon(R.drawable.ic_linkedin, R.string.cd_profileLinkedInIcon),
            SocialNetworkIcon(R.drawable.ic_instagram, R.string.cd_profileInstagramIcon)
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            StateAwareButton(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(6.dp),
                content = {
                    Text(
                        text = stringResource(R.string.profileEditProfileButton),
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                })
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(
                    text = stringResource(R.string.profileViewContactsButton),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

// todo move to common ui elements, add lambda with interaction source value, perhaps a custom view [tech debt]
@Composable
fun StateAwareButton(modifier: Modifier = Modifier, shape: Shape, content: @Composable () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val color = if (isPressed) {
        MaterialTheme.colorScheme.primary
    } else {
        Color.White
    }

    OutlinedButton(
        modifier = modifier,
        onClick = { /*TODO*/ },
        shape = shape,
        border = BorderStroke(width = 2.dp, color = Color.Black),
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun MyProfilePreview() {
    AndroidCourseTheme {
        MyProfileScreen(
            modifier = Modifier
                .background(DarkBlue)
                .fillMaxSize()
        )
    }
}