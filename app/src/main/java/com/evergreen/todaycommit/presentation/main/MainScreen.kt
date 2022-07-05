package com.evergreen.todaycommit.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.evergreen.todaycommit.R
import com.evergreen.todaycommit.presentation.extension.collectAsStateWithLifecycleRemember
import com.evergreen.todaycommit.presentation.main.components.RoundCornerBox
import com.evergreen.todaycommit.presentation.theme.Background
import com.evergreen.todaycommit.presentation.theme.Black
import com.evergreen.todaycommit.presentation.theme.Green300
import com.evergreen.todaycommit.presentation.theme.Grey200
import com.evergreen.todaycommit.presentation.theme.Grey300
import com.evergreen.todaycommit.presentation.theme.White
import com.evergreen.todaycommit.presentation.theme.suit

@Preview
@Composable
fun MainPreview() {
    MainScreen()
}

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val githubUser = viewModel.githubUser.collectAsStateWithLifecycleRemember(null).value
    val userName = githubUser?.userName
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            Modifier
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.padding(),
                    painter = painterResource(id = R.drawable.small_logo),
                    contentDescription = "logo"
                )

                Image(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "notification"
                )
            }

            Spacer(modifier = Modifier.height(21.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(userName ?: "연동 안됨")
                    }
                    append("님\n오늘도 잔디를 심어보세요!")
                },
                color = Black,
                fontSize = 20.sp,
                fontFamily = suit,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RoundCornerBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(106.dp),
                    alignment = Alignment.BottomCenter
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(
                                    bottomStart = 20.dp,
                                    bottomEnd = 20.dp
                                )
                            ),

                        painter = painterResource(id = R.drawable.grass1),
                        contentDescription = "notification"
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                RoundCornerBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(68.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
                                append("지금은 땅이 쉬는중이에요\n")
                            }
                            append("커밋해서 잔디 씨앗을 뿌려주세요")
                        },
                        color = Black,
                        fontSize = 12.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight.Normal
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                RoundCornerBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(91.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    SpanStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append("오늘 커밋 횟수 0")
                                    withStyle(SpanStyle(color = Grey300)) {
                                        append("/10\n")
                                    }
                                }
                                append("커밋을 할 수록 잔디가 무럭무럭 자라요!")
                            },
                            color = Black,
                            fontSize = 12.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        LinearProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(6.dp))
                                .height(12.dp)
                                .border(
                                    width = 1.dp,
                                    color = Green300,
                                    shape = CircleShape
                                ),
                            color = Green300,
                            trackColor = White,
                            progress = 0.7f
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    RoundCornerBox(
                        modifier = Modifier
                            .weight(1f)
                            .height(71.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        ) {
                            Text(
                                text = "현재 내 커밋 등수는?",
                                color = Grey200,
                                fontSize = 12.sp,
                                fontFamily = suit,
                                fontWeight = FontWeight.Normal
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.trophy),
                                    contentDescription = "trophy"
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "3등",
                                        color = Black,
                                        fontSize = 14.sp,
                                        fontFamily = suit,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.arrow),
                                        contentDescription = "arrow",
                                        alignment = Alignment.CenterEnd
                                    )
                                }

                            }
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    RoundCornerBox(
                        modifier = Modifier
                            .weight(1f)
                            .height(71.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        ) {
                            Text(
                                text = "내가 바로 잔디마스터",
                                color = Grey200,
                                fontSize = 12.sp,
                                fontFamily = suit,
                                fontWeight = FontWeight.Normal
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.calendar),
                                    contentDescription = "calendar"
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "내 커밋 기록",
                                        color = Black,
                                        fontSize = 14.sp,
                                        fontFamily = suit,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.arrow),
                                        contentDescription = "arrow",
                                    )
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}