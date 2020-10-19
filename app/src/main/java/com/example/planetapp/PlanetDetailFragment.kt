package com.example.planetapp

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.planet_detail_description.view.*
import kotlinx.android.synthetic.main.planet_detail_fragment.*
import kotlinx.android.synthetic.main.planet_detail_fragment.view.*
import javax.inject.Inject

class PlanetDetailFragment() : Fragment() {

    // arguments passed through the navigation graph
    private val args: PlanetDetailFragmentArgs by navArgs()

    @Inject
    lateinit var viewModel: PlanetDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().applicationContext as App).appComponent.inject(this)
    }

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

            // Glide is used to load the image
            Glide.with(this)
                .load(Uri.parse(it.imageUrl)).into(view.planetImage);


            // update the description boxes
            view.distanceFromSun.description_title.text = "Distance from Sun"
            view.distanceFromSun.description_text.text = it.distanceFromSun.toString()

            view.longDescription.description_title.text = "Description"
            view.longDescription.description_text.text = it.description

            view.planetType.description_title.text = "Planet Type"
            view.planetType.description_text.text = it.planetType

            view.surfaceGravity.description_title.text = "Surface Gravity"
            view.surfaceGravity.description_text.text = it.surfaceGravity.toString()
            // could be improved ^^ according to SOLID

            progressBarDetailFragment.visibility = View.GONE;

            visibleGroup.visibility = View.VISIBLE

        })

        viewModel.fetchPlanet(args.id)

    }
}
