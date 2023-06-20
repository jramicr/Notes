package com.gquesada.notes.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.gquesada.notes.R
import com.gquesada.notes.ui.notes.viewmodels.NoteAddViewModel

class NoteAddFragment : Fragment() {

    private lateinit var viewModel: NoteAddViewModel
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_note_add, container, false)
        initViews(view)

//        viewModel = ViewModelProvider(this)[NoteListViewModel::class.java]
        viewModel = ViewModelProvider(this)[NoteAddViewModel::class.java]
//        return inflater.inflate(R.layout.fragment_note_add, container, false)
        return view
    }

    private fun initViews(view: View) {
        with(view) {
            saveButton = view.findViewById<Button>(R.id.btn_save)
            saveButton.setOnClickListener {
                onSaveClicked()
            }

            cancelButton = view.findViewById<Button>(R.id.btn_cancel)
            cancelButton.setOnClickListener {
                navigateToFragment(NoteListFragment())
            }
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun onSaveClicked() {
        Toast.makeText(context, "Hello World", Toast.LENGTH_LONG).show()
    }
}