package kz.jumysbar.intelteam.ui.tools

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.jumysbar.intelteam.R

class ToolsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //  Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tools, container, false)
    }
}