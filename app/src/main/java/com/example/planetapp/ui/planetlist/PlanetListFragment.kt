package com.example.planetapp.ui.planetlist

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.planetapp.*
import kotlinx.android.synthetic.main.planet_list_fragment.*
import javax.inject.Inject


// interface PlanetListener {
//     fun onPlanetTapped(planetResponse: Int)
// }

class PlanetListFragment : Fragment() {


    @Inject
    lateinit var viewModel: PlanetListViewModel

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
        return inflater.inflate(R.layout.planet_list_fragment, container, false)
    }


    override fun onStart() {
        super.onStart()

        // this stuff is used a lot in the real app, so probably spend some time to understand it
        viewModel.viewState.observe(viewLifecycleOwner, Observer {


            // attach the adapter to the planet list in layout
            view_planet_list // this is xml id
                .apply {
                    setHasFixedSize(true)
                    // specify a viewAdapter (see also next example)
                    // ::onPlanetTapped is a reference to onPlanetTapped
                    adapter = RecycleAdapter(it.planetDataList, ::onPlanetTapped)
                }
        })

        viewModel.start()
    }



    // it's easier to have this function is the fragment because
    // findNavController is only available in fragments and activities
    fun onPlanetTapped(intent: RecycleAdapter.Intent) {
        when (intent) {
            is RecycleAdapter.Intent.ItemTapped -> {
                findNavController().navigate(
                    PlanetListFragmentDirections.actionPlanetListFragmentToPlanetDetailFragment(
                        intent.id
                    )
                )
            }
            is RecycleAdapter.Intent.FavouriteTapped -> {
                viewModel.handleFavouriteIntent(intent.id)
            }
        }

    }

}


