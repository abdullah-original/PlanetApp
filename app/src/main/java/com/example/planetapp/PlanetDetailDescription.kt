package com.example.planetapp

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.planet_detail_description.*

class PlanetDetailDescription
@JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        View.inflate(context, R.layout.planet_detail_description, this)
        // attrs?.let {
        //
        //     val typedArray = context.obtainStyledAttributes()
        // }
    }
}
