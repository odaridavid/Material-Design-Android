package com.github.odaridavid.materialx.animations

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.odaridavid.materialx.R


//TODO Dynamically choose interpolator
class ObjectAnimatorFragment : Fragment(R.layout.fragment_object_animator) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animatedTextView = view.findViewById<TextView>(R.id.animated_text_view)
        val startButton = view.findViewById<Button>(R.id.start_animation_button)

        val oaScaleX = ObjectAnimator.ofFloat(animatedTextView, View.SCALE_X, 0.7f, 1.0f).apply {
            duration = 4000
            interpolator = AnticipateOvershootInterpolator()
        }

        val oaScaleY = ObjectAnimator.ofFloat(animatedTextView, View.SCALE_Y, 0.7f, 1.0f).apply {
            duration = 4000
            interpolator = AnticipateOvershootInterpolator()
        }

        startButton.setOnClickListener {
            oaScaleX.start()
            oaScaleY.start()
        }
    }
}