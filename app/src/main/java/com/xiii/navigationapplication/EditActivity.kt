package com.xiii.navigationapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.xiii.navigationapplication.ui.edit.EditFragmentArgs
import kotlinx.android.synthetic.main.app_bar_main.*

class EditActivity : AppCompatActivity() {

    private val navController by lazy(LazyThreadSafetyMode.NONE) {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    private var isStartDestination = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setSupportActionBar(toolbar)

        val id = EditFragmentArgs.fromBundle(intent.extras)

        val startDestinationId = navController.graph.startDestination
        // будем принудительно подменять id, чтобы NavigationUI.ActionBarOnNavigatedListener не пытался скрыть кнопку
        // при этом для всех остальных destination будем предоставлять оригинальный startDestination
        navController.addOnNavigatedListener { controller, destination ->
            isStartDestination = destination.id == startDestinationId
            // R.id.fake_start_destination этот id вручную определён для семантики и обеспечения уникальности
            controller.graph.startDestination = if (isStartDestination) R.id.fake_start_destination else startDestinationId
        }
        // предоставим управление кнопкой "Назад" в toolbar
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        // на startDestination не будем использовать навигацию от Navigation Component
        return if (isStartDestination) super.onSupportNavigateUp() else navController.navigateUp()
    }

    fun takePhoto(view: View) {
        navController.navigate(R.id.action_editFragment_to_photoFragment)
    }
}
