package com.binayshaw7777.kotstep.ui.vertical

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.binayshaw7777.kotstep.model.VerticalStepperStyle
import com.binayshaw7777.kotstep.ui.vertical.step.RenderVerticalIcon
import com.binayshaw7777.kotstep.ui.vertical.step.RenderVerticalIconWithLabel
import com.binayshaw7777.kotstep.ui.vertical.step.RenderVerticalNumber
import com.binayshaw7777.kotstep.ui.vertical.step.RenderVerticalNumberWithLabel
import com.binayshaw7777.kotstep.ui.vertical.step.RenderVerticalTab
import com.binayshaw7777.kotstep.ui.vertical.step.RenderVerticalTabWithLabel


/**
 * Render the vertical stepper based on the style
 *
 * @param style The style of the vertical stepper
 */
@Composable
fun VerticalStepper(modifier: Modifier = Modifier, style: VerticalStepperStyle) {
    when (style) {

        is VerticalStepperStyle.Tab -> RenderVerticalTab(
            modifier = modifier,
            totalSteps = style.totalSteps,
            currentStep = style.currentStep,
            stepStyle = style.stepStyle
        )

        is VerticalStepperStyle.Icon -> RenderVerticalIcon(
            modifier = modifier,
            totalSteps = style.totalSteps,
            currentStep = style.currentStep,
            icons = style.icons,
            stepStyle = style.stepStyle
        )

        is VerticalStepperStyle.Number -> RenderVerticalNumber(
            modifier = modifier,
            totalSteps = style.totalSteps,
            currentStep = style.currentStep,
            stepStyle = style.stepStyle
        )

        is VerticalStepperStyle.NumberWithLabel -> RenderVerticalNumberWithLabel(
            modifier = modifier,
            totalSteps = style.totalSteps,
            currentStep = style.currentStep,
            labels = style.labels,
            stepStyle = style.stepStyle
        )

        is VerticalStepperStyle.IconWithLabel -> RenderVerticalIconWithLabel(
            modifier = modifier,
            totalSteps = style.totalSteps,
            currentStep = style.currentStep,
            icons = style.icons,
            labels = style.labels,
            stepStyle = style.stepStyle
        )

        is VerticalStepperStyle.TabWithLabel -> RenderVerticalTabWithLabel(
            modifier = modifier,
            totalSteps = style.totalSteps,
            currentStep = style.currentStep,
            labels = style.labels,
            stepStyle = style.stepStyle
        )
    }
}