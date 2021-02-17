package kz.jumysbar.intelteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kz.jumysbar.intelteam.ui.authorization.AuthorizationActivity


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
//        nav_view.setNavigationItemSelectedListener (this)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
//        navView.setNavigationItemSelectedListener (this)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        drawer_layout.closeDrawers()
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_authorization,R.id.nav_search,R.id.nav_tour,
            R.id.nav_tools,R.id.nav_useful_materials,
            R.id.nav_calendar,R.id.nav_weather,
        R.id.nav_history,R.id.nav_location,
        R.id.nav_settings), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        nav_view.setNavigationItemSelectedListener (this)


    }
//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.id_personal_page -> {
//               startActivity(Intent(this, AuthorizationActivity::class.java))
//            }
//            R.id.location_menu -> Toast.makeText(this, "location_menu", Toast.LENGTH_SHORT).show()
//            R.id.tools_menu -> Toast.makeText(this, "tools_menu", Toast.LENGTH_SHORT).show()
//            R.id.tour_menu -> Toast.makeText(this, "tour_menu", Toast.LENGTH_SHORT).show()
//            R.id.useful_materials_menu -> Toast.makeText(
//                this,
//                "useful_materials_menu",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        drawer_layout.closeDrawers()
//        return true
//    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}