package com.lo.mpm.matchs.oolimob.mobile.sports.omms.ui.uikit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.R
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.domain.utils.dayOfWeek
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.domain.utils.formattedDateDMMM
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.ui.state.ApplicationEventRt176
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.ui.theme.darkRed
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.ui.theme.white176
import com.lo.mpm.matchs.oolimob.mobile.sports.omms.ui.theme.yellow
import java.time.LocalDate


@Composable
fun SliderOfDate(
    modifier: Modifier = Modifier,
    selectedDate: LocalDate,
    event: (ApplicationEventRt176) -> Unit
) {
    val currentDate = LocalDate.now()
    val counter = remember { mutableLongStateOf(0) }
    val date1 = remember { (mutableStateOf<LocalDate>(currentDate.minusDays(2))) }
    val date2 = remember { (mutableStateOf<LocalDate>(currentDate.minusDays(1))) }
    val date3 = remember { (mutableStateOf<LocalDate>(currentDate)) }
    val date4 = remember { (mutableStateOf<LocalDate>(currentDate.plusDays(1))) }
    val date5 = remember { (mutableStateOf<LocalDate>(currentDate.plusDays(2))) }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = {
            if (counter.value > -3) {
                counter.value--
                date1.value = date1.value.minusDays(1)
                date2.value = date2.value.minusDays(1)
                date3.value = date3.value.minusDays(1)
                date4.value = date4.value.minusDays(1)
                date5.value = date5.value.minusDays(1)
            }
        }) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                contentDescription = "",
                tint = yellow
            )
        }
        ItemDatePicker(
            dayOfWeek = date1.value.dayOfWeek(),
            day = date1.value.formattedDateDMMM(),
            color = if (selectedDate==date1.value) yellow else white176,
            onClick = {
                event(ApplicationEventRt176.OnSetSelectedDateRt176(date1.value))
            })
        ItemDatePicker(
            dayOfWeek = date2.value.dayOfWeek(),
            day = date2.value.formattedDateDMMM(),
            color = if (selectedDate==date2.value) yellow else white176,
            onClick = {
                event(ApplicationEventRt176.OnSetSelectedDateRt176(date2.value))
            })
        ItemDatePicker(
            dayOfWeek = date3.value.dayOfWeek(),
            day = date3.value.formattedDateDMMM(),
            color = if (selectedDate==date3.value) yellow else white176,
            onClick = {
                event(ApplicationEventRt176.OnSetSelectedDateRt176(date3.value))
            })
        ItemDatePicker(
            dayOfWeek = date4.value.dayOfWeek(),
            day = date4.value.formattedDateDMMM(),
            color = if (selectedDate==date4.value) yellow else white176,
            onClick = {
                event(ApplicationEventRt176.OnSetSelectedDateRt176(date4.value))
            })
        ItemDatePicker(
            dayOfWeek = date5.value.dayOfWeek(),
            day = date5.value.formattedDateDMMM(),
            color = if (selectedDate==date5.value) yellow else white176,
            onClick = {
                event(ApplicationEventRt176.OnSetSelectedDateRt176(date5.value))
            })
        IconButton(onClick = {
            if (counter.longValue < 3) {
                counter.value++
                date1.value = date1.value.plusDays(1)
                date2.value = date2.value.plusDays(1)
                date3.value = date3.value.plusDays(1)
                date4.value = date4.value.plusDays(1)
                date5.value = date5.value.plusDays(1)
            }
        }) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "",
                tint = yellow
            )
        }
    }
}

@Composable
private fun ItemDatePicker(
    modifier: Modifier = Modifier,
    dayOfWeek: String,
    day: String,
    color: Color,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable (
            onClick = onClick
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier,
            text = dayOfWeek,
            style = TextStyle(
                fontSize = 12.sp,
                //fontFamily = FontFamily(Font(R.font.gilroy)),
                fontWeight = FontWeight(500),
                color = color
            )
        )
        Text(
            modifier = modifier,
            text = day,
            style = TextStyle(
                fontSize = 12.sp,
                //fontFamily = FontFamily(Font(R.font.gilroy)),
                fontWeight = FontWeight(500),
                color = color
            )
        )
    }
}