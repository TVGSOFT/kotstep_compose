package com.binayshaw7777.kotstep.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.binayshaw7777.kotstep.model.StepState
import com.binayshaw7777.kotstep.model.StepStyle

/**
 * Horizontal dashed step composable
 *
 * @param modifier Modifier
 * @param stepStyle StepStyle
 * @param stepState StepState
 * @param size IntSize
 */

@Composable
fun HorizontalDashedStep(
    modifier: Modifier = Modifier,
    stepStyle: StepStyle,
    stepState: StepState,
    size: IntSize
) {

    val transition = updateTransition(targetState = stepState, label = "")

    val containerColor: Color by transition.animateColor(label = "itemColor") {
        when (it) {
            StepState.TODO -> stepStyle.colors.todoContainerColor
            StepState.CURRENT -> stepStyle.colors.currentContainerColor
            StepState.DONE -> stepStyle.colors.doneContainerColor
        }
    }

    val contentColor: Color by transition.animateColor(label = "titleColor") {
        when (it) {
            StepState.TODO -> stepStyle.colors.todoContentColor
            StepState.CURRENT -> stepStyle.colors.currentContentColor
            StepState.DONE -> stepStyle.colors.doneContentColor
        }
    }

    val progressState: Float by transition.animateFloat(label = "progress") {
        when (it) {
            StepState.TODO -> 0f
            StepState.CURRENT -> 0.5f
            StepState.DONE -> 1f
        }
    }

    LinearProgressIndicator(
        progress = { progressState },
        modifier = Modifier.then(
            with(LocalDensity.current) {
                Modifier.widthIn(max = size.width.toDp())
                    .padding(2.dp)
            }
        ),
        color = containerColor,
        trackColor = containerColor,
        strokeCap = stepStyle.strokeCap
    )
}