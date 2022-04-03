package ru.nifontbus.lc4_design.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sailing
import androidx.compose.material.icons.filled.VideoCameraFront
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material.icons.outlined.WatchLater
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.nifontbus.lc4_design.R
import ru.nifontbus.lc4_design.ui.theme.DarkGray
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
        Column(
//            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            ReadyExamsCard(state)
            Classes()
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
fun Classes() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
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
fun ClassesCard() {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                    .clip(CircleShape)
                    .background(DarkGray)

            ) {
                Icon(
                    imageVector = Icons.Default.Sailing,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(12.dp)
                )
            }

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
                    Icon(
                        imageVector = Icons.Outlined.WatchLater,
                        contentDescription = "clock",
                        tint = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .size(20.dp)
                            .padding(end = 4.dp)
                    )
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
fun surfaceBrush() = Brush.linearGradient(
    colors = listOf(
        MaterialTheme.colors.secondary,
        MaterialTheme.colors.secondaryVariant
    )
)
