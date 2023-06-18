package eu.acolombo.harmonized.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.google.android.material.color.ColorRoles
import com.google.android.material.color.MaterialColors

@Immutable
data class HarmonizedColor(val harmonizedCustomColor: Color = Color.Unspecified)

internal object DefaultHarmonizedColor {
    fun get(): HarmonizedColor = HarmonizedColor(CustomColor)
}

internal object DynamicHarmonizedColor {
    fun get(colorScheme: ColorScheme) = HarmonizedColor(CustomColor.getHarmonized(colorScheme))
}

val LocalHarmonizedColor = staticCompositionLocalOf { HarmonizedColor() }

internal fun Color.getHarmonized(colorScheme: ColorScheme) = Color(
    MaterialColors.harmonize(toArgb(), colorScheme.primary.toArgb()),
)



