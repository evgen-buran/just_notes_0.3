package com.example.justnotes03.add_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.justnotes03.R
import com.example.justnotes03.databinding.FragmentAddNoteBinding
import com.example.justnotes03.room.AppNote
import com.example.justnotes03.utils.APP_ACTIVITY
import com.example.justnotes03.utils.showToast


class AddNote : Fragment() {
    private var _binding: FragmentAddNoteBinding? = null
    private val binding: FragmentAddNoteBinding get() = _binding!!
    lateinit var viewModel: AddNoteViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        addNote()
    }

    fun addNote() {
        binding.btnAddNote.setOnClickListener {
            val title = binding.etTitleNote.text.toString()
            val text = binding.etTextNote.text.toString()
            if (title.isEmpty()) {
                showToast(getString(R.string.enter_title))
            } else {
                viewModel.insert(AppNote(titleNote = title, textNote = text))
                APP_ACTIVITY.navController.navigate(R.id.action_addNote_to_mainFragment)
            }

        }

    }
}