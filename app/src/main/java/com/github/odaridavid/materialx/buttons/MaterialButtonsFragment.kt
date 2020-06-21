package com.github.odaridavid.materialx.buttons

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.odaridavid.materialx.R
import com.google.android.material.button.MaterialButtonToggleGroup


internal class MaterialButtonsFragment : Fragment(R.layout.fragment_material_buttons) {

    private lateinit var materialButtonToggleGroup: MaterialButtonToggleGroup
    private val materialButtonToggleGroupListener =
        MaterialButtonToggleGroup.OnButtonCheckedListener { group, checkedId, isChecked ->
            //TODO Logic here
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        materialButtonToggleGroup =
            view.findViewById<MaterialButtonToggleGroup>(R.id.material_toggle_button).apply {
                addOnButtonCheckedListener(materialButtonToggleGroupListener)
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        materialButtonToggleGroup.removeOnButtonCheckedListener(materialButtonToggleGroupListener)
    }
}