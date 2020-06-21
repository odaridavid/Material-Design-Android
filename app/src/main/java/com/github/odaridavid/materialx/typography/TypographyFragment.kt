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

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.odaridavid.materialx.R
import com.google.android.material.button.MaterialButton

//TODO Animate while transitioning to new fragment
internal class TypographyFragment : Fragment(R.layout.fragment_typography) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.typography_reference_button).setOnClickListener {
            findNavController().navigate(R.id.action_typographyFragment_to_typographyReferenceFragment)
        }
        view.findViewById<MaterialButton>(R.id.typography_demo_button).setOnClickListener {
            findNavController().navigate(R.id.action_typographyFragment_to_typographyDemoFragment)
        }
    }

}