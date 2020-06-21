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
package com.github.odaridavid.materialx.typography

import android.content.Context
import com.github.odaridavid.materialx.R
import com.github.odaridavid.materialx.commons.getImageDrawable


internal object TypographyDataGenerator {
    fun generateTypographyDemos(context: Context): List<TypographyDemo> {
        val headline = "Headliners Story"
        val subtitle = "David Odari"
        val body =
            "This is a story about a yada yada doing yada yada and he couldn't yada yada so he decided to yada yada"
        val caption = "27th March 2020"
        return listOf(
            TypographyDemo(
                context.getImageDrawable(R.drawable.city),
                "City View",
                headline,
                subtitle,
                body,
                caption
            ),
            TypographyDemo(
                context.getImageDrawable(R.drawable.fox),
                "Fox posing for a picture",
                headline,
                subtitle,
                body,
                caption
            ),
            TypographyDemo(
                context.getImageDrawable(R.drawable.mountain),
                "Mountain with snow at the peak",
                headline,
                subtitle,
                body,
                caption
            ),
            TypographyDemo(
                context.getImageDrawable(R.drawable.timber),
                "Timber on a path",
                headline,
                subtitle,
                body,
                caption
            )
        )
    }
}