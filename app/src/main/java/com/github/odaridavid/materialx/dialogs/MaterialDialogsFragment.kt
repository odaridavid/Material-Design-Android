/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.materialx.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.github.odaridavid.materialx.R
import com.github.odaridavid.materialx.commons.initButtonsStyle
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder


private interface IDialogController {

    fun toggleSimpleDialog()

    fun toggleAlertDialog()

    fun toggleConfirmationDialog()

    fun toggleMultipleChoiceConfirmationDialog()

    fun toggleCustomDialog()

}

internal class MaterialDialogsFragment : Fragment(R.layout.fragment_material_dialogs),
    IDialogController {

    private lateinit var alertDialogButton: MaterialButton
    private lateinit var simpleDialogButton: MaterialButton
    private lateinit var confirmationDialogButton: MaterialButton
    private lateinit var customDialogButton: MaterialButton
    private lateinit var multipleChoiceConfirmationButton: MaterialButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            alertDialogButton = findViewById(R.id.alert_dialog_button)
            simpleDialogButton = findViewById(R.id.simple_dialog_button)
            confirmationDialogButton = findViewById(R.id.confirmation_dialog_button)
            customDialogButton = findViewById(R.id.custom_dialog_button)
            multipleChoiceConfirmationButton =
                findViewById(R.id.multiple_choice_confirmation_dialog_button)
        }
        initOnClickListeners()
    }

    private fun initOnClickListeners() {
        for ((button, onClick) in createButtonToClickListenerMap()) {
            button.setOnClickListener { onClick() }
        }
    }

    private fun createButtonToClickListenerMap(): Map<View, () -> Unit> {
        return mapOf(
            alertDialogButton to ::toggleAlertDialog,
            simpleDialogButton to ::toggleSimpleDialog,
            confirmationDialogButton to ::toggleConfirmationDialog,
            customDialogButton to ::toggleCustomDialog,
            multipleChoiceConfirmationButton to ::toggleMultipleChoiceConfirmationDialog
        )
    }

    override fun toggleAlertDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Allow Chat Backup ?")
            .setMessage("Chats will be backed up every 48hrs.")
            .setNeutralButton("Skip", null)
            .setPositiveButton("Ok", null)
            .setNegativeButton("Cancel", null)
            .show()
            .initButtonsStyle()
    }

    override fun toggleSimpleDialog() {
        val levels = arrayOf("Easy", "Normal", "Difficult")
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Difficulty Level")
            .setItems(levels, null)
            .show()
    }

    override fun toggleConfirmationDialog() {
        val ringtones = arrayOf("Sunlight", "JukeBox", "Symphony", "Melody")
        val defaultCheckedItem = 1
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Phone Ringtone")
            .setNeutralButton("Cancel", null)
            .setPositiveButton("Ok", null)
            .setSingleChoiceItems(ringtones, defaultCheckedItem, null)
            .show()
            .initButtonsStyle()
    }

    override fun toggleMultipleChoiceConfirmationDialog() {
        val drinks = arrayOf("Tea", "Coffee", "Beer", "Wine")
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Drinks of choice")
            .setNeutralButton("Cancel", null)
            .setPositiveButton("Ok", null)
            .setMultiChoiceItems(drinks, null) { dialog, which, checked ->
                // Respond to item chosen
            }
            .show()
            .initButtonsStyle()
    }

    override fun toggleCustomDialog() {
        CustomDialog.show(childFragmentManager, "custom_dialog")
    }

    object CustomDialog : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
            MaterialAlertDialogBuilder(
                requireContext(),
                R.style.ThemeOverlay_App_MaterialAlertDialog
            ).setView(R.layout.view_material_dialog).create()
    }

}



