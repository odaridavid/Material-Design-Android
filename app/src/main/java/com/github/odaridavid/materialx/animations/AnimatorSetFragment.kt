package com.github.odaridavid.materialx.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.github.odaridavid.materialx.R


class AnimatorSetFragment : Fragment(R.layout.fragment_animator_set) {

    //TODO Add Reverse animation option
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageOne = view.findViewById<ImageView>(R.id.image_one_image_view)
        val imageTwo = view.findViewById<ImageView>(R.id.image_two_image_view)
        val startButton = view.findViewById<Button>(R.id.start_animation_button)

        val imageOneCoordinates = IntArray(2)
        val imageTwoCoordinates = IntArray(2)

        imageOne.getLocationOnScreen(imageOneCoordinates)
        imageTwo.getLocationOnScreen(imageTwoCoordinates)

        val imageOneInitialXPosition = imageOneCoordinates[0].toFloat()
        val imageTwoInitialXPosition = imageTwoCoordinates[0].toFloat()
        val imageOneInitialYPosition = imageOneCoordinates[1].toFloat()
        val imageTwoInitialYPosition = imageTwoCoordinates[1].toFloat()


        Log.i("AnimatorSet", "$imageOneInitialXPosition - $imageTwoInitialXPosition")

        val vaAlpha = ValueAnimator.ofFloat(0.0f, 1.0f).apply {
            duration = 3000
            addUpdateListener { valueAnimator ->
                val alphaValue = valueAnimator.animatedValue as Float
                imageOne.alpha = alphaValue
                imageTwo.alpha = alphaValue
            }
        }

        val imageOneTranslationY = PropertyValuesHolder.ofFloat(
            View.TRANSLATION_Y,
            -imageOneInitialYPosition,
            imageTwoInitialYPosition
        )

        val imageTwoTranslationY = PropertyValuesHolder.ofFloat(
            View.TRANSLATION_Y,
            imageTwoInitialYPosition,
            -imageOneInitialYPosition
        )

        //TODO Why is x always 0??
        val imageOneTranslationX = PropertyValuesHolder.ofFloat(
            View.TRANSLATION_X,
            imageOneInitialXPosition,
            -imageTwoInitialYPosition
        )

        val imageTwoTranslationX = PropertyValuesHolder.ofFloat(
            View.TRANSLATION_X,
            imageTwoInitialXPosition,
            imageTwoInitialYPosition
        )

        val oaImageOne =
            ObjectAnimator.ofPropertyValuesHolder(
                imageOne,
                imageOneTranslationY,
                imageOneTranslationX
            ).apply {
                duration = 2000
            }

        val oaImageTwo =
            ObjectAnimator.ofPropertyValuesHolder(
                imageTwo,
                imageTwoTranslationY,
                imageTwoTranslationX
            ).apply {
                duration = 2000
            }

        val animSet = AnimatorSet().apply {
            play(vaAlpha)
                .with(oaImageOne)
                .with(oaImageTwo)
        }

        startButton.setOnClickListener {
            animSet.start()
        }

    }
}