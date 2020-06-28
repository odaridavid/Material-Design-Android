/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.materialx;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


internal class HomeCategoryAdapter(val onClick: (Int) -> Unit) :
    ListAdapter<HomeCategory, HomeCategoryAdapter.HomeCategoryViewHolder>(DiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_home_category, parent, false)
        return HomeCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int): Unit =
        getItem(position).let { holder.bind(it) }

    inner class HomeCategoryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(category: HomeCategory) {
            with(view) {
                findViewById<ImageView>(R.id.home_category_icon_image_view).apply {
                    val icon = context.getDrawable(category.icon)
                    setImageDrawable(icon)
                }
                findViewById<TextView>(R.id.home_category_label_text_view).apply {
                    text = context.getString(category.name)
                }
            }
            view.setOnClickListener {
                onClick(category.navAction)
            }
        }
    }

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<HomeCategory>() {
            override fun areItemsTheSame(oldItem: HomeCategory, newItem: HomeCategory): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: HomeCategory, newItem: HomeCategory): Boolean {
                return oldItem == newItem
            }
        }
    }
}