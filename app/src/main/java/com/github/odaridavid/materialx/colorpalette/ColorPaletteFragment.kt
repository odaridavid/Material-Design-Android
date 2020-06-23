package com.github.odaridavid.materialx.colorpalette

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.palette.graphics.Palette
import com.github.odaridavid.materialx.R
import com.github.odaridavid.materialx.commons.getColor

//TODO Enable picking drawable to evaluate color
internal class ColorPaletteFragment : Fragment(R.layout.fragment_color_palette) {

    private val defaultColor: Int
        get() = getColor(R.color.color_white)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bitmap = getBitmap(randomDrawableRes())
        val palette = PaletteUtils.createPaletteSync(bitmap)

        view.findViewById<ImageView>(R.id.color_extraction_target_image_view).apply {
            setImageBitmap(bitmap)
        }
        setVibrantPalette(view, palette)
        setMutedPalette(view, palette)
    }

    private fun setMutedPalette(view: View, palette: Palette) {
        view.findViewById<ImageView>(R.id.muted_image_view).apply {
            val color = palette.getMutedColor(defaultColor)
            setBackgroundColor(color)
        }
        view.findViewById<ImageView>(R.id.light_muted_image_view).apply {
            val color = palette.getLightMutedColor(defaultColor)
            setBackgroundColor(color)
        }
        view.findViewById<ImageView>(R.id.dark_muted_image_view).apply {
            val color = palette.getDarkMutedColor(defaultColor)
            setBackgroundColor(color)
        }
    }

    private fun setVibrantPalette(view: View, palette: Palette) {
        view.findViewById<ImageView>(R.id.vibrant_image_view).apply {
            val color = palette.getVibrantColor(defaultColor)
            setBackgroundColor(color)
        }
        view.findViewById<ImageView>(R.id.light_vibrant_image_view).apply {
            val color = palette.getLightVibrantColor(defaultColor)
            setBackgroundColor(color)
        }
        view.findViewById<ImageView>(R.id.dark_vibrant_image_view).apply {
            val color = palette.getDarkVibrantColor(defaultColor)
            setBackgroundColor(color)
        }
    }

    private fun getBitmap(@DrawableRes id: Int) =
        BitmapFactory.decodeResource(requireContext().resources, id)

    @DrawableRes
    private fun randomDrawableRes(): Int {
        return when ((1..4).random()) {
            1 -> R.drawable.city
            2 -> R.drawable.timber
            3 -> R.drawable.mountain
            else -> R.drawable.fox
        }
    }
}