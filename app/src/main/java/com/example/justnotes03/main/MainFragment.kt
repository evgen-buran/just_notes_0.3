package com.example.justnotes03.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.currentComposer
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.justnotes03.R
import com.example.justnotes03.R.id
import com.example.justnotes03.databinding.FragmentMainBinding
import com.example.justnotes03.room.AppNote
import com.example.justnotes03.utils.APP_ACTIVITY
import com.example.justnotes03.utils.showToast

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding!!
    private lateinit var fragmentViewModel: MainFragmentViewModel
    lateinit var  recyclerView:RecyclerView
    lateinit var adapter: MainAdapter




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        recyclerView = binding.recyclerView
        adapter = MainAdapter()
        recyclerView.adapter = adapter
        binding.floatingActionButton.setOnClickListener{
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_addNote)
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
        fragmentViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        fragmentViewModel.initDatabase()
        fragmentViewModel.liveData.observe(this, Observer { adapter.setList(it) })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sortNotes -> {
                showToast("sort")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun click(note: AppNote) {
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_noteFragment, bundle)

        }
    }

}