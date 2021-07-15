package com.omercankoc.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.omercankoc.recyclerview.databinding.ActivityDetailsBinding
import com.omercankoc.recyclerview.databinding.ActivityDetailsBinding.inflate
import com.omercankoc.recyclerview.databinding.ActivityMainBinding.inflate

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var languagesList : ArrayList<Languages>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // View Binding
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Gelen veriyi al.
        val intent = intent
        val selectedlanguage = Singleton.chosenLanguage

        selectedlanguage?.let {
            binding.textViewLanguage.text = it.language
            binding.textViewYear.text = it.year.toString()
            binding.imageView.setImageResource(it.logo)
        }


    }
}