package com.example.myapplication.ui.BinEnterScreen

import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.ui.QueryListScreen.QueryListScreen


@Composable
fun BinEnterScreen(
    onNavigateToQueryList: () -> Unit,
    viewModel: BinEnterScreenVM = hiltViewModel()
) {
    val binField by viewModel.bin.collectAsState()
    val cardInfo by viewModel.cardInfo.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        SearchLine(
            query = binField,
            onValueChange = { viewModel.onChangeBin(it) },
            onSearchClick = { viewModel.callApi() })
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(16.dp)
        )
        CardInfoRow(label = stringResource(R.string.scheme_network), value = cardInfo.scheme)
        CardInfoRow(label = stringResource(R.string.brand), value = cardInfo.brand)
        CardInfoRow(
            label = stringResource(R.string.card_number_length),
            value = cardInfo.number.length.toString()
        )
        CardInfoRow(
            label = stringResource(R.string.luhn_valid),
            value = cardInfo.number.luhn.toString()
        )
        CardInfoRow(label = stringResource(R.string.type), value = cardInfo.type)
        CardInfoRow(label = stringResource(R.string.prepaid), value = cardInfo.prepaid.toString())
        CardInfoRow(label = stringResource(R.string.country), value = cardInfo.country.name)
        CardInfoRow(
            label = stringResource(R.string.latitude),
            value = cardInfo.country.latitude.toString()
        )
        CardInfoRow(
            label = stringResource(R.string.longitude),
            value = cardInfo.country.longitude.toString()
        )
        CardInfoRow(label = stringResource(R.string.bank_name), value = cardInfo.bank.name)
        CardInfoRow(label = stringResource(R.string.bank_city), value = cardInfo.bank.city)
        CardInfoRow(label = stringResource(R.string.bank_url), value = cardInfo.bank.url)
        CardInfoRow(label = stringResource(R.string.bank_phone), value = cardInfo.bank.phone)
        Button(onClick = onNavigateToQueryList) {
            Text(text = stringResource(R.string.all_query))
        }
    }
}

@Composable
fun CardInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = FontWeight.Bold)
        Text(text = value)
    }
}

@Composable
fun SearchLine(
    query: String,
    onValueChange: (String) -> Unit,
    onSearchClick: () -> Unit,
) {
    TextField(
        value = query,
        onValueChange = onValueChange,
        singleLine = true,
        trailingIcon = {
            IconButton(
                onClick = onSearchClick,
                modifier = Modifier
                    .clip(CircleShape)
            ) {
                Icon(
                    Icons.Outlined.Search,
                    contentDescription = ""
                )
            }
        },
        placeholder = { Text(text = stringResource(R.string.enter_bin)) },
        shape = RoundedCornerShape(28.dp),
        colors = TextFieldDefaults.colors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}