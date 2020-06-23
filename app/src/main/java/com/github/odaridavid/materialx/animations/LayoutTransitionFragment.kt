package com.github.odaridavid.materialx.animations

import android.animation.AnimatorSet
import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.github.odaridavid.materialx.R
import com.google.android.material.button.MaterialButton


class LayoutTransitionFragment : Fragment(R.layout.fragment_layout_transition) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val constraintLayout = view.findViewById<ConstraintLayout>(R.id.layout)
        val dummyTitle = view.findViewById<TextView>(R.id.dummy_title)

//        val layoutTransition = LayoutTransition().apply {
//            //TODO Appearing animation doesnt seem to be doing what its supposed to
//            val oaAlphaVisible =
//                ObjectAnimator.ofFloat(dummyTitle, View.ALPHA, dummyTitle.alpha, 1.0f)
//            val asAppearing = AnimatorSet().apply {
//                play(oaAlphaVisible)
//                duration = 6000
//            }
//
//            val oaAlphaInvisible =
//                ObjectAnimator.ofFloat(dummyTitle, View.ALPHA, dummyTitle.alpha, 0.0f)
//            val asDisappearing = AnimatorSet().apply {
//                play(oaAlphaInvisible)
//                duration = 2000
//            }
//
//            setAnimator(LayoutTransition.APPEARING, asAppearing)
//            setAnimator(LayoutTransition.DISAPPEARING, asDisappearing)
//        }
//
//        constraintLayout.layoutTransition = layoutTransition

        val sb = view.findViewById<MaterialButton>(R.id.show_button)
        val hb = view.findViewById<MaterialButton>(R.id.hide_button)
        val rb = view.findViewById<MaterialButton>(R.id.remove_button)

        sb.setOnClickListener {
            dummyTitle.visibility = View.VISIBLE
        }

        hb.setOnClickListener {
            dummyTitle.visibility = View.INVISIBLE
        }

        rb.setOnClickListener {
            dummyTitle.visibility = View.GONE
        }
    }

}