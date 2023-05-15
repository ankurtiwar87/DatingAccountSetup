package com.ankur.datingaccountsetup.api

import com.ankur.datingaccountsetup.Model.CountryInfo
import com.ankur.datingaccountsetup.Model.FlagModel
import com.ankur.datingaccountsetup.Model.FlagModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/countries")
    suspend fun getCountry():Response<FlagModel>

}