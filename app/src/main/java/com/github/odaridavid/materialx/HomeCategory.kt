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
package com.github.odaridavid.materialx

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes


internal data class HomeCategory(
    @StringRes val name: Int,
    @DrawableRes val icon: Int,
    @IdRes val navAction: Int
)


internal fun getHomeCategories(): List<HomeCategory> {
    return listOf(
        HomeCategory(
            R.string.label_typography,
            R.drawable.ic_typography_24,
            R.id.action_homeFragment_to_typographyFragment
        ),
        HomeCategory(
            R.string.label_buttons,
            R.drawable.ic_view_24,
            R.id.action_homeFragment_to_buttonsFragment
        ),
        HomeCategory(
            R.string.label_color_palette,
            R.drawable.ic_color_palette_24,
            R.id.action_homeFragment_to_colorPaletteFragment
        ),
        HomeCategory(
            R.string.label_animations,
            R.drawable.ic_animation_24,
            R.id.action_homeFragment_to_animationsFragment
        ),
        HomeCategory(
            R.string.label_input,
            R.drawable.ic_input_24,
            R.id.action_homeFragment_to_inputFragment
        ),
        HomeCategory(
            R.string.label_bottom_navigation,
            R.drawable.ic_navigation_24,
            R.id.action_homeFragment_to_bottomNavFragment
        ),
        HomeCategory(
            R.string.label_grids,
            R.drawable.ic_grid_24,
            R.id.action_homeFragment_to_gridsFragment
        ),
        HomeCategory(
            R.string.label_motion,
            R.drawable.ic_motion_24,
            R.id.action_homeFragment_to_motionLayoutFragment
        ),
        HomeCategory(
            R.string.label_dialog,
            R.drawable.ic_dialog_24,
            R.id.action_homeFragment_to_materialDialogsFragment
        )
    )
}