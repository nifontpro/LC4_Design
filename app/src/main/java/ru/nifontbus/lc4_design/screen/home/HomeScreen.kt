package ru.nifontbus.lc4_design.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import ru.nifontbus.lc4_design.R
import ru.nifontbus.lc4_design.ui.theme.Transparent10

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(paddingValues),
        topBar = {
            HomeTopBar()
        }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            ReadyExamsCard()
        }
    }
}

@Composable
fun ReadyExamsCard() {
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
                NumGroup(count = 9, label = "Days")
                DelimetrNum()
                NumGroup(count = 23, label = "Hours")
                DelimetrNum()
                NumGroup(count = 59, label = "Minutes")
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
private fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Greeting()
        TopActives()
    }
}

@Composable
private fun Greeting() {
    Text(
        style = MaterialTheme.typography.h5,
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                append("Hi, ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Mike!")
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
fun surfaceBrush() = Brush.linearGradient(
    colors = listOf(
        MaterialTheme.colors.secondary,
        MaterialTheme.colors.secondaryVariant
    )
)
