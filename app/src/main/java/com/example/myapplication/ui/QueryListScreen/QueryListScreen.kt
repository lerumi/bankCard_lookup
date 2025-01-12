package com.example.myapplication.ui.QueryListScreen

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.data.model.Card
import com.example.myapplication.ui.BinEnterScreen.CardInfoRow


@Composable
fun QueryListScreen(
    onNavigateBack: () -> Unit,
    viewModel: QueryListScreenVM = hiltViewModel()
) {
    val queryList by viewModel.queryList.collectAsState()
    var offset by remember { mutableStateOf(0f) }
    Column {
        Button(
            onClick = onNavigateBack,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = stringResource(R.string.back))
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(
                    orientation = Orientation.Vertical,
                    state = rememberScrollableState { distance ->
                        offset += distance
                        distance
                    }),
            contentPadding = PaddingValues(16.dp),

            ) {

            items(queryList) { item ->
                Card(cardInfo = item)
            }
        }
    }


}
@Composable
fun Card(cardInfo: Card){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.bin) + " " + cardInfo.bin,
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.scheme_network) + " " + cardInfo.scheme)
            Text(text = stringResource(R.string.brand) + " " + cardInfo.brand)
            Text(text = stringResource(R.string.card_number_length) + " " + cardInfo.number.length)
            Text(text = stringResource(R.string.luhn_valid) + " " + cardInfo.number.luhn)
            Text(text = stringResource(R.string.type) + " " + cardInfo.type)
            Text(text = stringResource(R.string.prepaid) + " " + cardInfo.prepaid)
            Text(text = stringResource(R.string.country) + " " + cardInfo.country.name)
            Text(text = stringResource(R.string.latitude) + " " + cardInfo.country.latitude)
            Text(text = stringResource(R.string.longitude) + " " + cardInfo.country.longitude)
            Text(text = stringResource(R.string.bank_name) + " " + cardInfo.bank.name)
            Text(text = stringResource(R.string.bank_city) + " " + cardInfo.bank.city)
            Text(text = stringResource(R.string.bank_url) + " " + cardInfo.bank.url)
            Text(text = stringResource(R.string.bank_phone) + " " + cardInfo.bank.phone)
        }
    }
}