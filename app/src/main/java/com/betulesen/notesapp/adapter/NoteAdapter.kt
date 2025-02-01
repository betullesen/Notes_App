package com.betulesen.notesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.betulesen.notesapp.databinding.NoteItemBinding
import com.betulesen.notesapp.model.Note
import com.betulesen.notesapp.ui.fragments.HomeFragmentDirections

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val itemBinding : NoteItemBinding): RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteDesc == newItem.noteDesc &&
                    oldItem.noteTitle == newItem.noteTitle
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]

        holder.itemBinding.noteTitleItem.text = currentNote.noteTitle
        holder.itemBinding.noteDesc.text = currentNote.noteDesc

        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(currentNote)
            it.findNavController().navigate(action)
        }

    }
}