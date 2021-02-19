package kz.jumysbar.intelteam

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var googleSignInClient: GoogleSignInClient? = null
    private var firebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        //   navView.setNavigationItemSelectedListener(this) drawer_layout.closeDrawers()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_authorization, R.id.nav_search, R.id.nav_tour,
                R.id.nav_tools, R.id.nav_useful_materials,
                R.id.nav_calendar, R.id.nav_weather,
                R.id.nav_history, R.id.nav_location,
                R.id.nav_settings, R.id.nav_exit
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.location_menu -> Toast.makeText(this, "location_menu", Toast.LENGTH_SHORT).show()
//            R.id.tools_menu -> Toast.makeText(this, "tools_menu", Toast.LENGTH_SHORT).show()
//  R.id.tour_menu -> Toast.makeText(this, "tour_menu", Toast.LENGTH_SHORT).show()
//  R.id.useful_materials_menu -> Toast.makeText(
//  this,
// "useful_materials_menu",
// Toast.LENGTH_SHORT
// .show()
// }
// drawer_layout.closeDrawers()
//  return true
// }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun exitUser(menuItem: MenuItem) {
        firebaseAuth = FirebaseAuth.getInstance()
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(this.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(applicationContext, options)
        googleSignInClient?.signOut()
        firebaseAuth?.signOut()
        val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        prefs.edit().putBoolean("googleUserSigned", false).apply()
        prefs.edit().apply {
            remove("googleUserID")
            clear()
        }.apply()
        val snackBar = Snackbar.make(drawer_layout, getString(R.string.snackbar_exit_auth), 2000)
        snackBar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
        val snackTextView =
            snackBar.view.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView
        snackTextView.textSize = 16f
        snackBar.show()
    }
}
