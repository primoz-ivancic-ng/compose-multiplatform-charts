package com.netguru.multiplatform.charts.line

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.netguru.multiplatform.charts.Util.checkComposable
import org.junit.Rule
import org.junit.Test

class LineWithLegendTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test // removed due to: https://github.com/pedrovgs/Shot/issues/265
    fun mixedValues_defaultUI() {
        checkComposable(composeRule) {
            LineChart(
                data = Data.generateLineData(3),
            )
        }
    }

    @Test // removed due to: https://github.com/pedrovgs/Shot/issues/265
    fun mixedValues_customUI() {
        checkComposable(composeRule) {
            LineChart(
                data = Data.generateLineData(3),
                legendConfig = LegendConfig(
                    legendItemLabel = { name, unit ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = name)
                            if (unit != null) {
                                Text(text = unit)
                            }
                        }
                    }
                ),
            )
        }
    }
}
