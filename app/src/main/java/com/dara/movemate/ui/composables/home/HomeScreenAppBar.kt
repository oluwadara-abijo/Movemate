package com.dara.movemate.ui.composables.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.ui.theme.Dimens.DefaultPadding
import com.dara.movemate.ui.theme.Dimens.PaddingQuarter
import com.dara.movemate.ui.theme.Dimens.ProfilePictureSize
import com.dara.movemate.ui.theme.MovemateColors

@Composable
fun HomeScreenAppBar() {
    Column(
        modifier = Modifier
            .background(MovemateColors.primary)
            .fillMaxWidth()
            .padding(DefaultPadding)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(ProfilePictureSize)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = DefaultPadding)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(14.dp),
                        painter = painterResource(id = R.drawable.near_me),
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.6F)
                    )
                    Text(
                        modifier = Modifier.padding(start = PaddingQuarter),
                        text = "Your location",
                        color = Color.White.copy(alpha = 0.6F),
                        fontSize = 14.sp
                    )
                }
                Row(
                    modifier = Modifier.padding(top = PaddingQuarter),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier.padding(start = PaddingQuarter),
                        text = "Wertheimer, Illinois",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Icon(
                        modifier = Modifier.padding(top = PaddingQuarter),
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1F))
            Icon(
                modifier = Modifier
                    .background(color = Color.White, shape = CircleShape)
                    .padding(8.dp)
                    .size(24.dp),
                imageVector = Icons.Outlined.Notifications,
                contentDescription = null,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = DefaultPadding)
                .background(color = Color.White, shape = RoundedCornerShape(32.dp))
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(start = 12.dp),
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.Gray
            )
            Text(
                modifier = Modifier.padding(start = PaddingQuarter),
                text = "Enter the receipt number ...",
                color = Color.Gray,
            )
            Spacer(modifier = Modifier.weight(1F))
            Image(
                modifier = Modifier
                    .background(color = MovemateColors.secondary, shape = CircleShape)
                    .padding(8.dp)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.barcode),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenAppBarPreview() {
    HomeScreenAppBar()
}