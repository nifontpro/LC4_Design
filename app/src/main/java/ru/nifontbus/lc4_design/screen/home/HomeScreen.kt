package ru.nifontbus.lc4_design.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sailing
import androidx.compose.material.icons.filled.VideoCameraFront
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.nifontbus.lc4_design.R
import ru.nifontbus.lc4_design.screen.component.CircleIcon
import ru.nifontbus.lc4_design.screen.component.ColorIcon
import ru.nifontbus.lc4_design.screen.component.IconClock
import ru.nifontbus.lc4_design.screen.component.surfaceBrush
import ru.nifontbus.lc4_design.ui.theme.SafeBlue
import ru.nifontbus.lc4_design.ui.theme.SafeGreen
import ru.nifontbus.lc4_design.ui.theme.Transparent10

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
) {
    val viewModel = viewModel<HomeViewModel>()
    val state = viewModel.state.value
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(paddingValues),
        topBar = {
            HomeTopBar(state.userName)
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            item { ReadyExamsCard(state) }
            item { Classes() }
            item { Homework(state) }
        }
    }
}

@Composable
private fun HomeTopBar(userName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Greeting(userName)
        TopActives()
    }
}

@Composable
private fun Greeting(userName: String) {
    Text(
        style = MaterialTheme.typography.h5,
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                append("Hi, ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(userName)
            }
        }
    )
}

@Composable
private fun TopActives() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconMod = Modifier.padding(12.dp)
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = "Search",
            modifier = iconMod
        )
        Icon(
            imageVector = Icons.Outlined.Tune,
            contentDescription = "Settings",
            modifier = iconMod
        )
        Image(
            painter = painterResource(id = R.drawable.avatar1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = iconMod
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun ReadyExamsCard(state: ScreenState) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.padding(vertical = 8.dp),
        elevation = 4.dp
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(surfaceBrush())
                .padding(vertical = 20.dp)
        ) {
            Text(
                text = "Are you ready for exams?",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Row {
                NumGroup(count = state.daysLeft, label = "Days")
                DelimetrNum()
                NumGroup(count = state.hoursLeft, label = "Hours")
                DelimetrNum()
                NumGroup(count = state.minutesLeft, label = "Minutes")
            }
        }
    }
}

@Composable
private fun DelimetrNum() {
    Text(
        text = ":",
        style = MaterialTheme.typography.h5,
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .padding(top = 5.dp)
    )
}

@Composable
private fun NumGroup(count: Byte, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val num = if (count > 99) 99 else count
        val num1 = num / 10
        val num2 = num % 10
        Row {
            BoxedNum(num = num1)
            BoxedNum(num = num2)
        }
        Text(text = label)
    }
}

@Composable
private fun BoxedNum(num: Int) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(4.dp)
            .clip(MaterialTheme.shapes.small)
            .background(Transparent10)
    ) {
        Text(
            text = num.toString(),
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun Classes() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Classes",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = "6 classes today",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground
            )
        }
        ClassesCard()
    }
}

@Composable
private fun ClassesCard() {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CircleIcon(Icons.Default.Sailing, Modifier.weight(1f))
            Column(modifier = Modifier.weight(3f)) {
                Text(
                    text = "History",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconClock()
                    Text(
                        text = "8:00 - 8:45",
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .height(100.dp)
            ) {
                Text(
                    text = "Open In",
                    style = MaterialTheme.typography.body2,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .rotate(90f)
                )
                Box(
                    modifier = Modifier
                        .padding(top = 22.dp)
                        .border(
                            BorderStroke(1.dp, MaterialTheme.colors.onSurface),
                            shape = CircleShape
                        )
                        .padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VideoCameraFront,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.dp)
                            .rotate(90f)
                    )
                }
            }
        }
    }
}

@Composable
private fun Homework(state: ScreenState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {

        Text(
            text = "Homework",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface
        )
        HomeworkList(state)
    }
}

@Composable
fun HomeworkList(state: ScreenState) {

    LazyRow(modifier = Modifier.padding(top = 16.dp)) {
        items(state.homework) { homework ->
            HomeworkCard(homework)
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeworkCard(
        homework = Homework(
            name = "Literature",
            daysLeft = 2,
            title = "Read scenes 1.1-1.12 of The Master and Margarita."
        )
    )
}

@Composable
fun HomeworkCard(homework: Homework) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .width(250.dp)
            .padding(end = 16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = homework.name,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconClock()
                        Text(
                            text = "${homework.daysLeft} days left",
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onBackground,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
                CircleIcon(image = Icons.Outlined.AutoStories, Modifier)
            } //row
            Text(
                text = homework.title,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Row {
                ColorIcon(
                    image = Icons.Outlined.Face,
                    modifier = Modifier,
                    background = SafeGreen,
                    tint = Color.White
                )
                ColorIcon(
                    image = Icons.Outlined.InsertEmoticon,
                    modifier = Modifier.offset(x = (-8).dp),
                    background = SafeBlue,
                    tint = Color.White
                )
            }
        } // column
    }
}
