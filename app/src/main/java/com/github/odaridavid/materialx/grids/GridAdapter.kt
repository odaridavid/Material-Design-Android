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
package com.github.odaridavid.materialx.grids;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.odaridavid.materialx.R
import com.github.odaridavid.materialx.customview.MaterialXImageView

internal class GridAdapter(val layout: Layout) :
    ListAdapter<GridItem, GridAdapter.GridItemViewHolder>(DiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridItemViewHolder {
        val context = parent.context
        val layoutId = when (layout) {
            Layout.GRID -> R.layout.item_grid
            Layout.STAGGERED_GRID -> R.layout.item_grid_staggered
            Layout.LINEAR -> R.layout.item_grid_linear
        }
        val view = LayoutInflater.from(context).inflate(layoutId, parent, false)
        return GridItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridItemViewHolder, position: Int): Unit =
        getItem(position).let { holder.bind(it) }

    inner class GridItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: GridItem) {
            with(view) {
                findViewById<MaterialXImageView>(R.id.grid_item_picture_image_view).apply {
                    val image = context.getDrawable(item.image)
                    setImageDrawable(image)
                }
                findViewById<TextView>(R.id.grid_item_title_text_view).apply {
                    text = context.getString(item.title)
                }
            }
        }
    }

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<GridItem>() {
            override fun areItemsTheSame(oldItem: GridItem, newItem: GridItem): Boolean {
                return oldItem.image == newItem.image && oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: GridItem, newItem: GridItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}