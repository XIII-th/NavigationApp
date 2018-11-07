package com.xiii.navigationapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xiii.navigationapplication.ui.edit.EditFragmentArgs

class EditFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // работает во остальных случаях, когда fragment не создаётся в качестве startDestination
        // val id = EditFragmentArgs.fromBundle(arguments)
        val id = EditFragmentArgs.fromBundle(requireActivity().intent.extras)
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }
}
