package com.example.jokeapp.screens.jokeOverview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jokeapp.database.jokes.Joke
import com.example.jokeapp.databinding.JokeListItemBinding

class JokeAdapter : ListAdapter<Joke, ViewHolder>(JokeDiffCallback()){
    //taken care of by ListAdapter
    /*var data = listOf<Joke>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }*/

    /*
    override fun getItemCount(): Int {
        return data.size
    }*/

    //fill up the item you need (e.g. set texts and images)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

}

//class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

class ViewHolder(val binding: JokeListItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(item: Joke) {
        binding.jokePunchlineTextview.text = item.punchline
        binding.jokeSetupTextview.text = item.jokeSetup
    }

    //this way the viewHolder knows how to inflate.
    //better than having this in the adapter.
    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = JokeListItemBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }
    }
}


class JokeDiffCallback: DiffUtil.ItemCallback<Joke>(){
    override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem.jokeId == newItem.jokeId
    }

    override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem == newItem
        //works perfectly because it's a dataclass.
    }
}