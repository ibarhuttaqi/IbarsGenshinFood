package com.example.ibarsgenshinfood.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun CartItem(
    menuId: Int,
    image: Int,
    name: String,
    totalPrice: Int,
    count: Int,
    onMenuCountChanged: (id: Int, count: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(Shapes.small)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1.0f)
        ) {
            Text(
                text = name,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = stringResource(
                    R.string.price,
                    totalPrice
                ),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall,
            )
        }
        MenuCounter(
            orderId = menuId,
            orderCount = count,
            onMenuIncreased = { onMenuCountChanged(menuId, count + 1) },
            onMenuDecreased = { onMenuCountChanged(menuId, count - 1) },
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CartItemPreview() {
    IbarsGenshinFoodTheme {
        CartItem(
            4, R.drawable.item_delicious_goulash, "Jaket Hoodie Dicoding", 4000, 0,
            onMenuCountChanged = { menuId, count -> },
        )
    }
}