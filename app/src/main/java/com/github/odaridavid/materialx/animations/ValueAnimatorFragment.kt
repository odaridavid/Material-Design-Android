package com.github.odaridavid.materialx.animations

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.odaridavid.materialx.R
import com.github.odaridavid.materialx.commons.getColor


class ValueAnimatorFragment : Fragment(R.layout.fragment_value_animations) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animatedTextView = view.findViewById<TextView>(R.id.animated_text_view)
        val startButton = view.findViewById<Button>(R.id.start_animation_button)
        val vaPosY = ValueAnimator.ofFloat(0.0f, 200.0f).apply {
            duration = 5000
            addUpdateListener { valueAnimator ->
                animatedTextView.translationY = valueAnimator.animatedValue as Float
            }
        }
        val vaColor =
            ValueAnimator.ofArgb(
                getColor(R.color.color_grey_50),
                getColor(R.color.color_pink_900_dark)
            ).apply {
                duration = 5000
                addUpdateListener { valueAnimator ->
                    animatedTextView.setTextColor(valueAnimator.animatedValue as Int)
                }
            }

        startButton.setOnClickListener {
            vaPosY.start()
            vaColor.start()
        }

    }
}