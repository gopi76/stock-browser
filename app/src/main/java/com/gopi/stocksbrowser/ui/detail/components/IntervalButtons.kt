package com.gopi.stocksbrowser.ui.detail.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gopi.stocksbrowser.ui.theme.StocksBrowserTheme
import com.gopi.stocksbrowser.usecases.GetRangeIntervalsUseCase
import com.gopi.stocksbrowser.usecases.RangeInterval
import com.gopi.stocksbrowser.usecases.SelectableRangeInterval
import com.gopi.stocksbrowser.usecases.toRangeInterval
import com.gopi.stocksbrowser.usecases.toSelectable

@Composable
fun IntervalButtons(
    choices: List<SelectableRangeInterval>,
    onClick: (RangeInterval) -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        choices.map {
            if (it.isSelected) {
                Button(onClick = { onClick(it.toRangeInterval()) }) {
                    Text(it.name)
                }
            } else {
                TextButton(onClick = { onClick(it.toRangeInterval()) }) {
                    Text(it.name)
                }
            }
        }
    }
}

@Preview(
    showBackground = true, widthDp = 400, uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Preview(showBackground = true, widthDp = 400, name = "Light Mode")
@Composable
fun IntervalButtons_Preview() {
    StocksBrowserTheme {
        IntervalButtons(
            GetRangeIntervalsUseCase().invoke()
                .mapIndexed { index, item -> item.toSelectable(index == 3) }
        ) {}
    }
}
