package kz.jumysbar.intelteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener (this)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_account_menu -> {Snackbar.make(activity_main_container, "id_account_menu", 3000).setAction("Отменить") {
            }.show()}
            R.id.location_menu -> Toast.makeText(this,"location_menu", Toast.LENGTH_SHORT).show()
            R.id.tools_menu -> Toast.makeText(this,"tools_menu", Toast.LENGTH_SHORT).show()
            R.id.tour_menu -> Toast.makeText(this,"tour_menu", Toast.LENGTH_SHORT).show()
            R.id.useful_materials_menu -> Toast.makeText(this,"useful_materials_menu", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}