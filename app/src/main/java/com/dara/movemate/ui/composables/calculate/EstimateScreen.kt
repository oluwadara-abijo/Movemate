package com.dara.movemate.ui.composables.calculate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.ui.composables.Screen
import com.dara.movemate.ui.composables.components.ActionButton
import com.dara.movemate.ui.composables.components.SecondaryText
import com.dara.movemate.ui.theme.MovemateColors
import com.dara.movemate.ui.theme.green_text

@Composable
fun EstimateScreen(
    goBackHome: () -> Unit
) {
    var animateComponents by remember { mutableStateOf(false) }
    var price by remember { mutableIntStateOf(1070) }
    val priceCounter by animateIntAsState(
        targetValue = price,
        animationSpec = tween(
            durationMillis = 2000,
            easing = LinearEasing
        ),
        label = "price"
    )

    LaunchedEffect(Unit) {
        animateComponents = true
        price = 1460
    }

    Screen {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            AnimatedContent(shouldAnimate = animateComponents) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "MoveMate",
                        color = MovemateColors.primary,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Icon(
                        modifier = Modifier
                            .size(48.dp)
                            .padding(start = 8.dp, bottom = 2.dp),
                        painter = painterResource(id = R.drawable.logo_truck),
                        contentDescription = null,
                        tint = MovemateColors.secondary
                    )
                }
            }
            AnimatedVisibility(
                visible = animateComponents,
                enter = scaleIn(
                    animationSpec = tween(2000)
                ) + fadeIn()
            ) {
                Icon(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.movemate_box),
                    contentDescription = null,
                    tint = MovemateColors.outline
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AnimatedContent(shouldAnimate = animateComponents) {
                    Text(
                        text = stringResource(R.string.total_estimated_amount),
                        fontSize = 26.sp
                    )
                }
                AnimatedContent(shouldAnimate = animateComponents) {
                    Text(
                        text = stringResource(id = R.string.estimated_price, priceCounter),
                        fontSize = 26.sp,
                        color = green_text
                    )
                }
                AnimatedContent(shouldAnimate = animateComponents) {
                    SecondaryText(
                        text = stringResource(id = R.string.estimate_description),
                        paddingValues = PaddingValues(top = 8.dp),
                        alignment = TextAlign.Center
                    )
                }
            }
            AnimatedContent(shouldAnimate = animateComponents) {
                ActionButton(
                    onButtonClick = goBackHome,
                    label = R.string.back_to_home,
                    labelFontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun AnimatedContent(
    shouldAnimate: Boolean,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = shouldAnimate,
        enter = slideInVertically(
            animationSpec = tween(2000),
            initialOffsetY = { fullHeight -> fullHeight * 2 })
                + fadeIn(animationSpec = tween(2000)),
    ) {
        content()
    }
}
