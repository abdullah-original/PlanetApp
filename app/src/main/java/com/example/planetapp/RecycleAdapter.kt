package com.example.planetapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class RecycleAdapter(private val data: Array<Planet>, private val listener: PlanetListener) :
    RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder>() {


    class RecycleViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    // Create new views (invoked by the layout manager)
    //
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)


        println("Adapter: onCreateViewHolder")
        return RecycleViewHolder(view)
    }

    // insert data into the view holder
    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.view.planet_name.text = data[position].name
        holder.view.planet_description.text = data[position].description

        // pass data to click listener
        holder.view.setOnClickListener {
            listener.onPlanetTapped(data[position]);
        }
    }

    // return size of data
    override fun getItemCount() = data.size



}


