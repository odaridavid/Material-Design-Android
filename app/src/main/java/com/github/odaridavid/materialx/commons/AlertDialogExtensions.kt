/*
*
* Copyright 2020 David Odari
*
* Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except 
* in compliance with the License. You may obtain a copy of the License at
*
*          http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software distributed under the License 
* is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
* or implied. See the License for the specific language governing permissions and limitations under
* the License.
*
*/
package com.github.odaridavid.materialx.commons

import android.content.DialogInterface
import androidx.annotation.ColorRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.github.odaridavid.materialx.R


internal fun AlertDialog.getColor(@ColorRes id: Int): Int {
    return ContextCompat.getColor(context, id)
}

internal fun AlertDialog.initButtonsStyle() {
    getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.color_pink_900))
    getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getColor(R.color.color_pink_900))
    getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(getColor(R.color.color_grey_800))
}