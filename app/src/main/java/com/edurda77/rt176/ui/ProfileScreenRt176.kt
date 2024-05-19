package com.edurda77.rt176.ui

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edurda77.rt176.R
import com.edurda77.rt176.domain.utils.PERS_DATA
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176
import com.edurda77.rt176.ui.state.TypeProfileRt176
import com.edurda77.rt176.ui.state.TypeProfileRt176.DataRt176
import com.edurda77.rt176.ui.state.TypeProfileRt176.EditDataRt176
import com.edurda77.rt176.ui.theme.black
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.grey
import com.edurda77.rt176.ui.theme.white176
import com.edurda77.rt176.ui.theme.yellow
import com.edurda77.rt176.ui.uikit.BottomNavigationRow

@Preview
@Composable
private fun Sample() {
   ProfileScreenRt176(
       name = "",
       phone = "7888888",
       applicationStRt176 = ApplicationStRt176.Profile(DataRt176()),
       typeProfileRt176 = EditDataRt176(),
       event = {})
}



@Composable
fun ProfileScreenRt176(
    modifier: Modifier = Modifier,
    name: String,
    phone: String,
    applicationStRt176: ApplicationStRt176,
    typeProfileRt176: TypeProfileRt176,
    event: (ApplicationEventRt176) -> Unit
) {
    val updatedName = remember { mutableStateOf(name) }
    val updatedPhone = remember { mutableStateOf(phone) }
    val context = LocalContext.current

    val terms = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight(400),
                //fontFamily = FontFamily(Font(R.font.gilroy)),
                fontSize = 14.sp,
                color = grey
            )
        ) {
            append(stringResource(R.string.tr_1))
        }
        append(" ")
        pushStringAnnotation(
            tag = stringResource(R.string.tr_2), annotation = ""
        )
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight(400),
                //fontFamily = FontFamily(Font(R.font.gilroy)),
                fontSize = 14.sp,
                color = grey,
                textDecoration = TextDecoration.Underline,
            )
        ) {
            append(stringResource(id = R.string.tr_2))
        }
        pop()
    }



    BackHandler {
        event(ApplicationEventRt176.OnSetApplicationStateRt176(ApplicationStRt176.StartRt176()))
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = white176,
        topBar = {
            Box(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .fillMaxWidth()
                    .background(color = darkRed)
                    .padding(horizontal = 20.dp, vertical = 10.dp),
            ) {
                Text(
                    modifier = modifier.align(alignment = Alignment.CenterStart),
                    text = stringResource(R.string.profile),
                    style = TextStyle(
                        fontSize = 32.sp,
                        color = yellow,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
            }
        },
        bottomBar = {
            BottomNavigationRow(
                applicationStRt176 = applicationStRt176,
                name = name,
                phone = phone,
                event = event
            )
        }
    ) { paddings ->
        Column(
            modifier = modifier
                .padding(paddings)
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            when (typeProfileRt176) {
                is DataRt176 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image_profile),
                            contentDescription = ""
                        )
                        Spacer(modifier = modifier.height(16.dp))
                        Text(
                            modifier = modifier.fillMaxWidth(),
                            text = name,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = yellow,
                                textAlign = TextAlign.Center,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(700),
                            )
                        )
                        Spacer(modifier = modifier.height(32.dp))
                        Box(
                            modifier = modifier
                                .clip(shape = RoundedCornerShape(18.dp))
                                .fillMaxWidth()
                                .background(color = grey)
                                .padding(vertical = 24.dp, horizontal = 21.dp)
                        ) {
                            Text(
                                modifier = modifier.align(alignment = Alignment.CenterStart),
                                text = phone,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    color = black,
                                    textAlign = TextAlign.Center,
                                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                                    fontWeight = FontWeight(400),
                                )
                            )
                        }
                    }
                    Button(
                        modifier = modifier
                            .align(alignment = Alignment.CenterHorizontally),
                        shape = RoundedCornerShape(14.dp),
                        contentPadding = PaddingValues(vertical = 30.dp, horizontal = 50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = darkRed
                        ),
                        onClick = {
                            event(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.Profile(
                                        EditDataRt176()
                                    )
                                )
                            )
                        }
                    ) {
                        Text(
                            modifier = modifier,
                            text = stringResource(R.string.correct),
                            style = TextStyle(
                                fontSize = 20.sp,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(700),
                                color = yellow
                            )
                        )
                    }
                }

                is EditDataRt176 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image_profile),
                            contentDescription = ""
                        )
                        Spacer(modifier = modifier.height(16.dp))
                        TextField(
                            modifier = modifier
                                .fillMaxWidth(),
                            value = updatedPhone.value,
                            onValueChange = {
                                updatedPhone.value = it
                            },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(400),
                                color = black,
                            ),
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.enter_phone),
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                                        fontWeight = FontWeight(400),
                                        color = grey,
                                    )
                                )
                            },
                            shape = RoundedCornerShape(18.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Phone
                            ),
                            maxLines = 1,
                            singleLine = true
                        )
                        Spacer(modifier = modifier.height(16.dp))
                        TextField(
                            modifier = modifier
                                .fillMaxWidth(),
                            value = updatedName.value,
                            onValueChange = {
                                updatedName.value = it
                            },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = black,
                            ),
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.your_name),
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(400),
                                        color = grey,
                                    )
                                )
                            },
                            shape = RoundedCornerShape(18.dp),
                            maxLines = 1,
                            singleLine = true
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Button(
                            modifier = modifier
                                .align(alignment = Alignment.CenterHorizontally),
                            shape = RoundedCornerShape(14.dp),
                            contentPadding = PaddingValues(vertical = 30.dp, horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = darkRed
                            ),
                            onClick = {
                                event(
                                    ApplicationEventRt176.OnUpdateProfileRt176(
                                        name = updatedName.value,
                                        phone = updatedPhone.value
                                    )
                                )
                                event(
                                    ApplicationEventRt176.OnSetApplicationStateRt176(
                                        ApplicationStRt176.Profile(
                                            DataRt176()
                                        )
                                    )
                                )
                            }
                        ) {
                            Text(
                                modifier = modifier,
                                text = if (updatedName.value.isNotBlank() && updatedPhone.value.isNotBlank()) stringResource(
                                    R.string.to_save
                                ) else stringResource(
                                    R.string.correct
                                ),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                                    fontWeight = FontWeight(700),
                                    color = yellow
                                )
                            )
                        }
                        Spacer(modifier = modifier.height(16.dp))
                        ClickableText(
                            modifier = modifier.fillMaxWidth(),
                            style = TextStyle(
                                textAlign = TextAlign.Center
                            ),
                            onClick = { offset ->
                                terms.getStringAnnotations(
                                    tag = "персональных данных",
                                    offset,
                                    offset
                                )
                                    .firstOrNull()?.let { annotation ->
                                        val uri = Uri.parse(PERS_DATA)
                                        val intent = Intent(Intent.ACTION_VIEW, uri)
                                        context.startActivity(intent)
                                    }
                            },
                            text = terms,
                        )
                    }
                }
            }
        }
    }
}