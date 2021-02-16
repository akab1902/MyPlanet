package kz.jumysbar.intelteam

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kz.jumysbar.intelteam.ui.AuthorizationActivity


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_personal_page -> {
               startActivity(Intent(this, AuthorizationActivity::class.java))
            }
            R.id.location_menu -> Toast.makeText(this, "location_menu", Toast.LENGTH_SHORT).show()
            R.id.tools_menu -> Toast.makeText(this, "tools_menu", Toast.LENGTH_SHORT).show()
            R.id.tour_menu -> Toast.makeText(this, "tour_menu", Toast.LENGTH_SHORT).show()
            R.id.useful_materials_menu -> Toast.makeText(
                this,
                "useful_materials_menu",
                Toast.LENGTH_SHORT
            ).show()
        }
        activity_main_container.closeDrawers()
        return true
    }




}