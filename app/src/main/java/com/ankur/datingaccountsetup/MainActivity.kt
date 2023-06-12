package com.ankur.datingaccountsetup

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankur.datingaccountsetup.Model.FlagModelItem
import com.ankur.datingaccountsetup.adapters.CountryAdapter
import com.ankur.datingaccountsetup.api.ApiInterface
import com.ankur.datingaccountsetup.api.ApiUtilities
import com.ankur.datingaccountsetup.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.countryRecyclerView.layoutManager=LinearLayoutManager(this)
        getCountryFlag()

       binding.nextBtn.setOnClickListener {
       Intent(applicationContext,FillYourProfile::class.java).also {
           startActivity(it)
       }

        }





    }


    private fun getCountryFlag() {
        val apiCall = ApiUtilities.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launch(Dispatchers.IO) {

            val apiResult = apiCall.getCountry()


            if (apiResult.body()!=null)
            {
                withContext(Dispatchers.Main) {



                    val adapter=CountryAdapter(this@MainActivity,apiResult.body()!!)
                    binding.countryRecyclerView.adapter=adapter

                }
            }


        }

    }



}