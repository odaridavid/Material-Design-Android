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

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

//TODO Readme with typography
internal class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        handleSystemBars()
        super.onCreate(savedInstanceState)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun handleSystemBars() {
        if (versionFrom(Build.VERSION_CODES.M))
            setLightSystemBars()
        else
            setDefaultSystemBarColors()
    }

    private fun setDefaultSystemBarColors() {
        window.navigationBarColor = ContextCompat.getColor(this, R.color.color_grey_800_dark)
        window.statusBarColor = ContextCompat.getColor(this, R.color.color_grey_800_dark)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setLightSystemBars() {
        window.decorView.systemUiVisibility = setUiVisibilityFlags()
        window.navigationBarColor = getColor(R.color.color_white)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setUiVisibilityFlags(): Int =
        if (versionFrom(Build.VERSION_CODES.O))
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        else
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}