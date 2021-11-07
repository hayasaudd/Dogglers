/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import javax.sql.DataSource as DataSource1

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

       // TODO: Initialize the data using the List found in data/DataSource
      // val dogs: List<Dog> = listOf()
    /**
     * Initialize view elements
     */
    private val dataset = DataSource.dogs

    class DogCardViewHolder(private val  view: View?): RecyclerView.ViewHolder(view!!) {
        // TODO: Declare and initialize all of the list item UI components
        val image :ImageView = view!!.findViewById(R.id.imageView)
        val textview1 :TextView = view!!.findViewById(R.id.name)
        val textview2 :TextView = view!!.findViewById(R.id.age)
        val textview3 :TextView = view!!.findViewById(R.id.hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        return when (layout) {
            Layout.GRID->{
                val adapterLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.grid_list_item,parent,false)
                DogCardViewHolder(adapterLayout)
            }
            else -> {
                val adapterLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_horizontal_list_item,parent,false)
                DogCardViewHolder(adapterLayout)
            }
        }

        return DogCardViewHolder(null)
    }

    override fun getItemCount(): Int = dataset.size // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        val item=dataset[position]

        // TODO: Set the image resource for the current dog
        holder.image.setImageResource(item.imageResourceId)

        // TODO: Set the text for the current dog's name

        holder.textview1.text=item.name
        val resources=context?.resources

        // TODO: Set the text for the current dog's age

        holder.textview2.text=resources?.getString(R.string.dog_age,item.age)

        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)

        holder.textview3.text= resources?.getString(R.string.dog_hobbies,item.hobbies)
    }
}
