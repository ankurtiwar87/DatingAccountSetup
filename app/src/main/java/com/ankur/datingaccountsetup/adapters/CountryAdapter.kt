package com.ankur.datingaccountsetup.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ankur.datingaccountsetup.Model.FlagModel
import com.ankur.datingaccountsetup.Model.FlagModelItem
import com.ankur.datingaccountsetup.R
import com.ankur.datingaccountsetup.databinding.CountryItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CountryAdapter(private val context: Context,private var list : List<FlagModelItem>,private var listener:OnItemClickListener):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {




    inner class CountryViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){


         var binding=CountryItemBinding.bind(itemView)



     }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

         val view = LayoutInflater.from(context).inflate(R.layout.country_item,parent,false)
         val viewHolder = CountryViewHolder(view)
         view.setOnClickListener{
             listener.onClickItem(list[viewHolder.adapterPosition])

         }

        return viewHolder
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

    interface OnItemClickListener{
        fun onClickItem(item:FlagModelItem)

    }

}

