package com.example.planetapp.ui.planetlist

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.planetapp.R
import com.example.planetapp.domain.PlanetListData
import kotlinx.android.synthetic.main.list_item.view.*

class RecycleAdapter(
    private val data: List<PlanetListData>,
    private val itemTappedListener: (intent: Intent) -> Unit // this is a reference to a lambda function
) :
    RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder>() {


    class RecycleViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return RecycleViewHolder(
            view
        )
    }

    // insert data into the view holder
    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.view.planet_name.text = data[position].name
        holder.view.planet_description.text = data[position].description
        // holder.view.planet_image.setImageURI(Uri.parse(data[position].imageURL))


        Glide.with(holder.view.context)
            .load(Uri.parse(data[position].imageURL)).into(holder.view.planet_image);


        if (data[position].isFavourite) {
            holder.view.favourite_heart.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            holder.view.favourite_heart.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }

        // android gives preference to children, so if heart is clicked, it will have preference
        holder.view.favourite_heart.setOnClickListener {
            itemTappedListener(
                Intent.FavouriteTapped(
                    data[position].id
                )
            )
        }

        // pass data to click listener
        holder.view.setOnClickListener {
            itemTappedListener(
                Intent.ItemTapped(
                    data[position].id
                )
            )
        }
    }

    // return size of data
    override fun getItemCount() = data.size


    sealed class Intent {

        // for navigation
        data class ItemTapped(
            val id: Int
        ) : Intent()

        // for remembering favourite
        data class FavouriteTapped(
            val id: Int
        ) : Intent()

    }
}


