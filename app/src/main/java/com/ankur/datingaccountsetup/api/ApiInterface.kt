package com.ankur.datingaccountsetup.api

import com.ankur.datingaccountsetup.Model.flagModel
import com.ankur.datingaccountsetup.Model.flagModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("npm/country-flag-emoji-json@2.0.0/dist/index.json")
    suspend fun getCountry():Response<flagModel>

}