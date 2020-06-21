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
package com.github.odaridavid.materialx.typography;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.odaridavid.materialx.R


internal class TypographyDemoAdapter :
    ListAdapter<TypographyDemo, TypographyDemoAdapter.TypographyDemoViewHolder>(DiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypographyDemoViewHolder {
        val context = parent.context
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_typography_demo, parent, false)
        return TypographyDemoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TypographyDemoViewHolder, position: Int): Unit =
        getItem(position).let { holder.bind(it) }

    inner class TypographyDemoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(demo: TypographyDemo) {
            with(view) {
                findViewById<TextView>(R.id.typography_demo_headline_text_view).text = demo.headline
                findViewById<TextView>(R.id.typography_demo_overline_text_view).text = demo.overline
                findViewById<TextView>(R.id.typography_demo_body_text_view).text = demo.body
                findViewById<TextView>(R.id.typography_demo_caption_text_view).text = demo.caption
                findViewById<ImageView>(R.id.typograpy_demo_image_view).apply {
                    contentDescription = demo.imageDescription
                    setImageDrawable(demo.image)
                }
            }
        }
    }

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<TypographyDemo>() {
            override fun areItemsTheSame(
                oldItem: TypographyDemo,
                newItem: TypographyDemo
            ): Boolean = true

            override fun areContentsTheSame(
                oldItem: TypographyDemo,
                newItem: TypographyDemo
            ): Boolean = true
        }
    }
}