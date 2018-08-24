package com.coderefer.learndagger2

import com.coderefer.learndagger2.network.DateTimeConverter
import com.coderefer.learndagger2.network.GithubService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [NetworkModule::class])
public class GithubServiceModule {

    @Provides
    @GithubApplicationScope
    fun githubService(githubRetrofit: Retrofit) : GithubService {
        return githubRetrofit.create(GithubService::class.java)
    }

    @Provides
    @GithubApplicationScope
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(DateTime::class.java, DateTimeConverter())
        return gsonBuilder.create()
    }

    @Provides
    @GithubApplicationScope
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson) : Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com")
                .build()
    }

}