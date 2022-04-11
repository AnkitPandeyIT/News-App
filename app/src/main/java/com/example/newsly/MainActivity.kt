package com.example.newsly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getNews()
    }

    private fun getNews() {
        val news = newsService.newsInstance.getHeadLines("in",1)
        news.enqueue(object: Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val new = response.body()
                if (new!=null){
                    Log.d("ankush", new.toString())
                    adapter = NewsAdapter(this@MainActivity , new.artical)
                    var newsListRecy = findViewById<RecyclerView>(R.id.recyNewsList)
                    newsListRecy.adapter = adapter
                    newsListRecy.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("ankitPandey","error in featching news")
            }
        })
    }
}