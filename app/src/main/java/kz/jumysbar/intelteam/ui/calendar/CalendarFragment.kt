package kz.jumysbar.intelteam.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.andrewjapar.rangedatepicker.CalendarPicker
import kotlinx.android.synthetic.main.fragment_calendar.*
import kz.jumysbar.intelteam.R
import java.util.*

class CalendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val startDate = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault())
        val endDate = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault())
        endDate.add(Calendar.MONTH, 6) // Add 6 months ahead from current date

        calendar_view.apply {
            setMode(CalendarPicker.SelectionMode.RANGE) // You can set it via XML
            setRangeDate(startDate.time, endDate.time)
            setSelectionDate(startDate.time)
        }
        calendar_view.setOnRangeSelectedListener { startDate, endDate, startLabel, endLabel ->
            departure_date.text = startLabel
            return_date.text = endLabel
        }

        calendar_view.setOnStartSelectedListener { startDate, label ->
            departure_date.text = label
            return_date.text = "-"
        }

    }
}