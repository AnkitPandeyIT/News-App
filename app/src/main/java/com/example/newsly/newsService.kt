package com.example.newsly

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "295b16063bc048819d2714655f32bfde"

interface newsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") country: String, @Query("page") page: Int): Call<News>
}
    // retrofit object
    object newsService{
        val newsInstance:newsInterface
        init {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

            newsInstance = retrofit.create(newsInterface::class.java)
        }


    }
