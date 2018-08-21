package com.coderefer.learndagger2

import android.app.Application
import com.coderefer.learndagger2.network.DateTimeConverter
import com.coderefer.learndagger2.network.GithubService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DaggerApplication : Application() {
    lateinit var githubService :GithubService
    override fun onCreate() {
        super.onCreate()

        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(DateTime::class.java, DateTimeConverter())

        val gson = gsonBuilder.create()

        val okHttpClient = OkHttpClient()

        val githubRetrofit =Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com")
                .build()

        githubService = githubRetrofit.create(GithubService::class.java)
    }
}