package com.example.justnotes03.note

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.justnotes03.R
import com.example.justnotes03.databinding.FragmentNoteBinding
import com.example.justnotes03.room.AppNote
import com.example.justnotes03.utils.APP_ACTIVITY

class NoteFragment : Fragment() {

    private lateinit var viewModel: NoteViewModel
    private var _binding: FragmentNoteBinding? = null
    private val binding
        get() = _binding!!
    lateinit var note: AppNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    @SuppressLint("NewApi")
    override fun onStart() {
        super.onStart()
        init()
    }

    private fun init() {


        note = arguments?.getSerializable("note") as AppNote
        binding.tvTitleNoteDetail.text = note?.titleNote
        binding.tvTextNoteDetail.text = note?.textNote
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_note_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.deleteItemMenu -> {
                viewModel.delete(note)
                APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
            }
        }
        return super.onOptionsItemSelected(item)

    }


}