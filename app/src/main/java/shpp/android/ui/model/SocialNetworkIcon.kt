package shpp.android.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SocialNetworkIcon(
    @DrawableRes val id: Int,
    @StringRes val contentDescription: Int
)
