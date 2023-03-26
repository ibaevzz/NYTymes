package com.example.nytimes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.nytimes.R
import com.example.nytimes.databinding.ActivityMainBinding
import com.example.nytimes.models.Multimedia
import com.example.nytimes.models.Story
import com.example.nytimes.viewmodels.NYViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val nyviewModel: NYViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = nyviewModel
        binding.executePendingBindings()

        nyviewModel.data.observe(this){
            val list: MutableList<Story> = mutableListOf()
            for(i in it.stories){
                val title = i.title
                val url = i.url
                val imageUrls: MutableList<String> = mutableListOf()
                val multimedia: List<Multimedia> = i.multimedia
                for(imageUrl in multimedia){
                    imageUrls.add(imageUrl.url)
                }

                list.add(Story(title = title, url = url, imageUrls = imageUrls))
            }
            nyviewModel.adapter.setData(list)
        }
    }
}