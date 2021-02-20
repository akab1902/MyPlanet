package kz.jumysbar.intelteam.ui.tour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tour.*
import kz.jumysbar.intelteam.R

class TourFragment : Fragment(R.layout.fragment_tour) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tour, container, false)
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val images = listOf<imageForTour>(
                imageForTour("Кайынды","Южный Казахстан", R.drawable.kayndy),
                imageForTour("Туркестан","Южный Казахстан", R.drawable.turkestan),
                imageForTour("Иссык куль","Кыргызстан", R.drawable.issyk),
                imageForTour("Самарканд","Узбекистан", R.drawable.samarkand),
                imageForTour("Санкт-Петербург","Россия", R.drawable.st_petersburg)
        )

        recycler_view_tour.apply {
            layoutManager= LinearLayoutManager(activity)
            adapter = activity?.applicationContext?.let { RecyclerAdapter(it, images) }
        }
    }
}