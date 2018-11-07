package com.xiii.navigationapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {

    private val navController by lazy(LazyThreadSafetyMode.NONE) {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            val direction = ImportFragmentDirections.edit(123 /* id заметки */)
            navController.navigate(direction)
        }

        // прелоставим управление "гамбургером" в toolbar
        NavigationUI.setupWithNavController(toolbar, navController, drawer_layout)
        // связывание контроллера навигации и мееню
        nav_view.setupWithNavController(navController)
    }

    // добавим поддержку кнопуи назад
    override fun onSupportNavigateUp() = navController.navigateUp()
}
