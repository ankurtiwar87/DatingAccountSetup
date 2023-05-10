package com.ankur.datingaccountsetup.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ankur.datingaccountsetup.Model.flagModelItem
import com.ankur.datingaccountsetup.R
import com.ankur.datingaccountsetup.databinding.CountryItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CountryAdapter(private val context: Context,private var list : List<flagModelItem>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        var binding=CountryItemBinding.bind(itemView)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        return CountryViewHolder(LayoutInflater.from(context).inflate(R.layout.country_item,parent,false))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        var currentItem = list[position]
        holder.binding.countryName.text=currentItem.name
        Glide.with(context).load(currentItem.image).apply(RequestOptions.centerCropTransform()).into(holder.binding.CountryImage)
    }

}

