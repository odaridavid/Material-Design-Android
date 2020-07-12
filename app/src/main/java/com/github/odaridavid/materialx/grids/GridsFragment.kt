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
package com.github.odaridavid.materialx.grids

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.github.odaridavid.materialx.R


internal class GridsFragment : Fragment(R.layout.fragment_grids) {

    private var currentLayout = Layout.LINEAR

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvGrids = view.findViewById<RecyclerView>(R.id.grids_recycler_view)
        rvGrids.init(currentLayout)
        view.findViewById<ImageButton>(R.id.selected_grid_image_button).apply {
            setOnClickListener {
                currentLayout = when (currentLayout) {
                    Layout.LINEAR -> {
                        setImageDrawable(requireContext().getDrawable(R.drawable.ic_grid_24))
                        Layout.GRID
                    }
                    Layout.GRID -> {
                        setImageDrawable(requireContext().getDrawable(R.drawable.ic_staggered_grid_24))
                        Layout.STAGGERED_GRID
                    }
                    Layout.STAGGERED_GRID -> {
                        setImageDrawable(requireContext().getDrawable(R.drawable.ic_default_grid))
                        Layout.LINEAR
                    }
                }
                rvGrids.init(currentLayout)
            }
        }
    }

    //TODO Dynamic span count
    private fun RecyclerView.init(layout: Layout) {
        val a = GridAdapter(layout).apply {
            submitList(getGridItems())
        }
        val lm: RecyclerView.LayoutManager = when (layout) {
            Layout.LINEAR -> LinearLayoutManager(requireContext())
            Layout.STAGGERED_GRID -> StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )
            Layout.GRID -> GridLayoutManager(requireContext(), 2)
        }
        layoutManager = lm
        adapter = a
    }

}

enum class Layout {
    GRID,
    STAGGERED_GRID,
    LINEAR
}