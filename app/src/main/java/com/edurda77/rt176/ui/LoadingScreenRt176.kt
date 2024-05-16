package com.edurda77.rt176.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edurda77.rt176.R
import com.edurda77.rt176.ui.theme.grey
import com.edurda77.rt176.ui.theme.white176
import com.edurda77.rt176.ui.theme.yellow


@Preview
@Composable
fun LoadingScreenRt176 (
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column (
            modifier = modifier
                .align(alignment = Alignment.BottomCenter)
                .padding(bottom = 100.dp),
            verticalArrangement = Arrangement.Center,
        ){
            CircularProgressIndicator(
                modifier = Modifier.size(64.dp),
                color = grey,
                trackColor = yellow,
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(R.string.loading),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Font(R.font.gilroy)),
                    color = white176,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}