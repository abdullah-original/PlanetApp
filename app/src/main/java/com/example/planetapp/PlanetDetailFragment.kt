package com.example.planetapp

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.planet_detail_fragment.view.*

class PlanetDetailFragment() : Fragment() {

    // arguments passed through the navigation graph
    private val args: PlanetDetailFragmentArgs by navArgs()

    private val viewModel: PlanetDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.planet_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


        // update the view when changes are observed
        viewModel.viewState.observe(viewLifecycleOwner, Observer {

            view.planetName.text = it.name
            view.planetDescription.text = it.shortDescription

            // Glide is used to
            Glide.with(this)
                .load(Uri.parse(it.imageUrl)).into(view.planetImage);
        })

        viewModel.fetchPlanet(args.id)

    }
}
