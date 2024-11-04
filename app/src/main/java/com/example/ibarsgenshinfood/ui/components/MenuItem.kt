package com.example.ibarsgenshinfood.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ibarsgenshinfood.R
import com.example.ibarsgenshinfood.ui.theme.IbarsGenshinFoodTheme
import com.example.ibarsgenshinfood.ui.theme.Shapes

@Composable
fun MenuItem(
    name: String,
    price: Int,
    quality: Int,
    image: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Box {
            Image(
                painter = painterResource(image),
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(170.dp)
                    .clip(Shapes.small)
            )
            Image(
                painter = painterResource(quality),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(90.dp, 20.dp)
            )
        }
        Text(
            text = name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )
        Text(
            text = stringResource(R.string.price, price),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MenuItemPreview() {
    IbarsGenshinFoodTheme {
        MenuItem(name = "Jagung Bakar", price = 10000, quality = R.drawable.icon_5_stars, image = R.drawable.item_delicious_pile_em_up)
    }
}