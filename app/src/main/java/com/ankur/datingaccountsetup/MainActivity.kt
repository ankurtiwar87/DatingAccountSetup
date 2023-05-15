package com.ankur.datingaccountsetup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class MainActivity : AppCompatActivity() ,CountryAdapter.OnItemClickListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchView :SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.countryRecyclerView.layoutManager=LinearLayoutManager(this)

        getCountryFlag()

    }

    private fun getCountryFlag() {
        val apiCall = ApiUtilities.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launch(Dispatchers.IO) {

            val apiResult = apiCall.getCountry()


            if (apiResult.body()!=null)
            {
                withContext(Dispatchers.Main) {



                    val adapter=CountryAdapter(this@MainActivity,apiResult.body()!!,this@MainActivity)
                    binding.countryRecyclerView.adapter=adapter

                }
            }


        }

    }


    override fun onClickItem(item: FlagModelItem) {

    }


}