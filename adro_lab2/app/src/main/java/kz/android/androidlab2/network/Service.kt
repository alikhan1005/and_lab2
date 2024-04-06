package kz.android.androidlab2.network

import kz.android.androidlab2.models.Figure
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Service {
    @Headers("X-Api-Key:ehFjfHNDcBUzylRJ5TeIAQ==ShEv2UzRekrfPdCG")
    @GET("historicalfigures")
    fun getFiguresByName(@Query("name") name: String): Call<List<Figure>>
}