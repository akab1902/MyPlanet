package kz.jumysbar.intelteam.ui.tour

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_tour.view.*
import kz.jumysbar.intelteam.R

class RecyclerAdapter(
    private val context : Context,
    private val images : List <imageForTour>
): RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder>() {


    class ImageViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img = itemView.img_tour
        val place = itemView.placeOfTour
        val country = itemView.countryOfTour
        fun bindView(image: imageForTour){
            img.setImageResource(image.imgForTour)
            place.text = image.place
            country.text = image.country
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tour, parent, false))

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }
}