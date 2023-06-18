package eu.acolombo.harmonized.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.google.android.material.color.ColorRoles
import com.google.android.material.color.MaterialColors

@Immutable
data class HarmonizedColors(
    val accent: Color = Color.Unspecified,
    val onAccent: Color = Color.Unspecified,
    val accentContainer: Color = Color.Unspecified,
    val onAccentContainer: Color = Color.Unspecified,
)

internal object DefaultHarmonizedColors {
    fun get(darkTheme: Boolean) = CustomColor.getColorScheme(darkTheme)
        .toHarmonizedColors()
}

internal object DynamicHarmonizedColors {
    fun get(
        colorScheme: ColorScheme,
        darkTheme: Boolean,
    ) = CustomColor.getHarmonized(colorScheme)
        .getColorScheme(darkTheme)
        .toHarmonizedColors()
}

val LocalHarmonizedColors = staticCompositionLocalOf { HarmonizedColors() }

private fun Color.getColorScheme(darkTheme: Boolean): ColorRoles =
    MaterialColors.getColorRoles(this.toArgb(), !darkTheme)

private fun ColorRoles.toHarmonizedColors(): HarmonizedColors = HarmonizedColors(
    accent = Color(accent),
    onAccent = Color(onAccent),
    accentContainer = Color(accentContainer),
    onAccentContainer = Color(onAccentContainer),
)




