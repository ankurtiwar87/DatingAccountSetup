package com.ankur.datingaccountsetup.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ankur.datingaccountsetup.Model.FlagModelItem
import com.ankur.datingaccountsetup.R
import com.ankur.datingaccountsetup.databinding.CountryItemBinding
import com.bumptech.glide.Glide

class CountryAdapter(private val context: Context,private var list : List<FlagModelItem>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {




    inner class CountryViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){


         var binding=CountryItemBinding.bind(itemView)



     }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.country_item, parent, false)


        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        var currentItem = list[position]
        holder.binding.countryName.text=currentItem.country
        holder.binding.countryCode.text=currentItem.countryInfo.iso2
        Glide.with(context).load(currentItem.countryInfo.flag).into(holder.binding.CountryImage)
    }



}

