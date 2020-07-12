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
package com.github.odaridavid.materialx.bottomnav

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.github.odaridavid.materialx.R
import com.github.odaridavid.materialx.commons.showToast
import com.google.android.material.bottomnavigation.BottomNavigationView


internal class BottomNavFragment : Fragment(R.layout.fragment_bottom_navigation),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var bottomNav: BottomNavigationView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNav = view.findViewById(R.id.bottom_navigation)
        bottomNav?.setOnNavigationItemSelectedListener(this)
        //Set a notification badge
        val badge = bottomNav?.getOrCreateBadge(Destination.NOTIFICATIONS.id)
        badge?.isVisible = true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (val id = item.itemId) {
            Destination.HOME.id -> {
                context?.showToast("Home")
                true
            }
            Destination.SEARCH.id -> {
                context?.showToast("Search")
                true
            }
            Destination.SETTINGS.id -> {
                context?.showToast("Settings")
                true
            }
            Destination.NOTIFICATIONS.id -> {
                context?.showToast("Notifications")
                val badgeDrawable = bottomNav?.getBadge(id)
                badgeDrawable?.run {
                    isVisible = false
                }
                true
            }
            else -> false
        }
    }

}

enum class Destination(@IdRes val id: Int) {
    HOME(R.id.action_home),
    SEARCH(R.id.action_search),
    SETTINGS(R.id.action_settings),
    NOTIFICATIONS(R.id.action_notifications)
}