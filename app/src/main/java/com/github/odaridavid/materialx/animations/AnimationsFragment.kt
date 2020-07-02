package com.github.odaridavid.materialx.animations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.odaridavid.materialx.R
import com.github.odaridavid.materialx.commons.navigateOnClick

internal class AnimationsFragment : Fragment(R.layout.fragment_animations) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateOnClick(
            R.id.object_animator_button,
            R.id.action_animationsFragment_to_objectAnimatorFragment
        )

        navigateOnClick(
            R.id.value_animator_button,
            R.id.action_animationsFragment_to_valueAnimationsFragment
        )

        navigateOnClick(
            R.id.animator_set_button,
            R.id.action_animationsFragment_to_animatorSetFragment
        )

        navigateOnClick(
            R.id.animator_set_button,
            R.id.action_animationsFragment_to_layoutTransitionFragment
        )

        navigateOnClick(
            R.id.lottie_animation_button,
            R.id.action_animationsFragment_to_lottieFragment
        )

    }

}