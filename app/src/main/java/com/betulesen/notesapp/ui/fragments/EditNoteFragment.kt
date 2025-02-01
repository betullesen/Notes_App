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
import androidx.appcompat.app.AlertDialog
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.betulesen.notesapp.R
import com.betulesen.notesapp.databinding.FragmentAddBinding
import com.betulesen.notesapp.databinding.FragmentEditNoteBinding
import com.betulesen.notesapp.model.Note
import com.betulesen.notesapp.ui.activity.MainActivity
import com.betulesen.notesapp.viewmodel.NoteViewModel

class EditNoteFragment : Fragment(R.layout.fragment_edit_note),MenuProvider {

    private var _binding: FragmentEditNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var currentNote : Note

    private val args : EditNoteFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost : MenuHost = requireActivity()
        menuHost.addMenuProvider(this,viewLifecycleOwner, Lifecycle.State.RESUMED)

        noteViewModel = (activity as MainActivity).noteViewModel
        currentNote = args.note!!

        binding.editNoteTitle.setText((currentNote.noteTitle))
        binding.editNoteDescription.setText(currentNote.noteDesc)

        binding.editNoteFab.setOnClickListener {
            val noteTitle = binding.editNoteTitle.text.toString().trim()
            val noteDesc = binding.editNoteDescription.text.toString().trim()

            if (noteTitle.isNotEmpty()){
                val note = Note(currentNote.id,noteTitle,noteDesc)
                noteViewModel.updateNote(note)
                view.findNavController().popBackStack(R.id.homeFragment,false)
            }else{
                Toast.makeText(context,"Please enter a note title",Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun deleteNote(){
        activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle("Delete Note")
                setMessage("Do you want to delete this note?")
                setPositiveButton("Delete"){ _,_ ->
                    noteViewModel.deleteNote(currentNote)
                    Toast.makeText(context,"Note deleted",Toast.LENGTH_SHORT).show()
                    view?.findNavController()?.popBackStack(R.id.homeFragment,false)
                }
                setNegativeButton("Cancel",null)
            }.create().show()
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.edit_note_menu,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.deleteMenu -> {
                deleteNote()
                true
            }else -> false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}



