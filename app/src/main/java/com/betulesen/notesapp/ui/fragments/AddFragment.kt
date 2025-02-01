package com.betulesen.notesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.betulesen.notesapp.R
import com.betulesen.notesapp.databinding.FragmentAddBinding
import com.betulesen.notesapp.databinding.FragmentHomeBinding
import com.betulesen.notesapp.model.Note
import com.betulesen.notesapp.ui.activity.MainActivity
import com.betulesen.notesapp.viewmodel.NoteViewModel


class AddFragment : Fragment(R.layout.fragment_add),MenuProvider {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private lateinit var noteViewModel : NoteViewModel
    private lateinit var addNoteView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost : MenuHost = requireActivity()
        menuHost.addMenuProvider(this,viewLifecycleOwner,Lifecycle.State.RESUMED)

        noteViewModel = (activity as MainActivity).noteViewModel
        addNoteView = view
    }

    private fun saveNote(view: View){
        val noteTitle = binding.addNoteTitle.text.toString().trim()
        val noteDesc = binding.addNoteDescription.text.toString().trim()

        if(noteTitle.isNotEmpty()){
           val note = Note(0,noteTitle,noteDesc)
           noteViewModel.addNote(note)

            Toast.makeText(addNoteView.context,"Note Saved",Toast.LENGTH_SHORT).show()
            view.findNavController().popBackStack(R.id.homeFragment,false)
        }else{
            Toast.makeText(addNoteView.context,"Please enter a note title",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.add_note_menu,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.saveMenu -> {
                saveNote(addNoteView)
                true
            }
            else -> false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}