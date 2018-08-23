package com.coderefer.learndagger2

import com.coderefer.learndagger2.network.GithubService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
public class GithubServiceModule {

    @Provides
    fun githubService(githubRetrofit: Retrofit) : GithubService {
        return githubRetrofit.create(GithubService::class.java)
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson) : Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com")
                .build()
    }

}