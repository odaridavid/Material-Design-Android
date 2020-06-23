package com.github.odaridavid.materialx.animations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.odaridavid.materialx.R
import com.google.android.material.button.MaterialButton

class AnimationsFragment : Fragment(R.layout.fragment_animations) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.object_animator_button).setOnClickListener {
            findNavController().navigate(R.id.action_animationsFragment_to_objectAnimatorFragment)
        }
        view.findViewById<MaterialButton>(R.id.value_animator_button).setOnClickListener {
            findNavController().navigate(R.id.action_animationsFragment_to_valueAnimationsFragment)
        }
        view.findViewById<MaterialButton>(R.id.animator_set_button).setOnClickListener {
            findNavController().navigate(R.id.action_animationsFragment_to_animatorSetFragment)
        }
        view.findViewById<MaterialButton>(R.id.layout_transition_button).setOnClickListener {
            findNavController().navigate(R.id.action_animationsFragment_to_layoutTransitionFragment)
        }
    }

}