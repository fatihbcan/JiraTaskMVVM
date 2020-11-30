package com.example.jirataskmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    /*  override fun onBackPressed() {
          if (supportFragmentManager.backStackEntryCount == 1) {
              finish();

          } else {
              supportFragmentManager.popBackStack();
              Toast.makeText(this,"Back button clicked !!",Toast.LENGTH_LONG).show()
          }


      }*/

    fun setupNavigation() {
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment? ?: return

        val navController: NavController = host.navController
        val myNav: NavigationView = findViewById<NavigationView>(R.id.navigationView)
        myNav.setupWithNavController(navController)
    }

}
