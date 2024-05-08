package shpp.android.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import shpp.android.R
import shpp.android.ui.model.SocialNetworkIcon


@Composable
fun SocialNetworkRow(
    vararg networkIcons: SocialNetworkIcon
) {
    Row(
        modifier = Modifier.padding(top = 62.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        //flexibility showoff
        networkIcons.forEach { icon ->
            SocialNetworkImage(icon.id, stringResource(icon.contentDescription))
        }
    }
}

@Composable
fun ProfileInfoColumn() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlFaAvDX_Hej3RM0IbhlzDTzNxrDXNOZk6w7tr9IX367CZsvLXa4ZyBVxQ-r4kD4MTf4M&usqp=CAU",
            contentDescription = stringResource(R.string.cd_profileImage),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(113.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Kostyan", color = MaterialTheme.colorScheme.onPrimary, fontSize = 18.sp
        ) // todo remove hardcode
        Text(
            text = "career",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            text = "address",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
fun SocialNetworkImage(resourceId: Int, contentDescription: String) {
    Image(
        painter = painterResource(id = resourceId), contentDescription = contentDescription
    )
}