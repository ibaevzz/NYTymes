package com.example.nytimes.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.nytimes.R
import com.example.nytimes.models.Story

class StoriesAdapter: RecyclerView.Adapter<StoriesAdapter.Holder>() {

    private var stories: List<Story> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.story_card, parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(stories[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Story>){
        stories = list
        notifyDataSetChanged()
    }

    inner class Holder(val binding: ViewDataBinding) : ViewHolder(binding.root){
        fun bind(story: Story){
            binding.setVariable(BR.story, story)
            binding.root.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(story.url)
                }
                it.context.startActivity(intent)
            }
            binding.executePendingBindings()
        }
    }
}