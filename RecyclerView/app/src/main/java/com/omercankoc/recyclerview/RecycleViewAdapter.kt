package com.omercankoc.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omercankoc.recyclerview.databinding.RecyclerRowBinding

class RecycleViewAdapter(private val languageList : ArrayList<Languages>) : RecyclerView.Adapter<RecycleViewAdapter.LanguageHolder>() {

    class LanguageHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    // View holder ile olusturuldugunda yurut. Layout ile bagla.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LanguageHolder(binding)
    }

    // Baglandiktan sonra yurut. Data-View baglantisi.
    override fun onBindViewHolder(holder: LanguageHolder, position: Int) {
        holder.binding.textViewRecycleItem.text = languageList[position].language
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            //intent.putExtra("languaage", languageList[position])
            Singleton.chosenLanguage =languageList[position]
            holder.itemView.context.startActivity(intent)
        }
    }

    // Item sayisini al.
    override fun getItemCount(): Int {
        return languageList.size
    }
}