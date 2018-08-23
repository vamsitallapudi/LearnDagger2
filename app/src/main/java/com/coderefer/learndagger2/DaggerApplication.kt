package com.coderefer.learndagger2

import android.app.Application
import com.coderefer.learndagger2.network.DateTimeConverter
import com.coderefer.learndagger2.network.GithubService
import com.google.gson.GsonBuilder
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File

class DaggerApplication : Application() {

    private lateinit var githubService :GithubService
    private lateinit var picasso:Picasso


    override fun onCreate() {
        super.onCreate()


        Timber.plant(Timber.DebugTree())


//    CONTEXT
        val context = this

//      NETWORK
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Timber.i(it)
        })

        val cacheFile = File(getCacheDir(),"okhttp_cache")
        cacheFile.mkdirs()

        val cache = Cache(cacheFile, 10*1024*1024/* 10 MB cache*/)



//     PICASSO
       picasso = Picasso.Builder(context)
                .downloader(OkHttp3Downloader(okHttpClient))
                .build()

//     GSON
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(DateTime::class.java, DateTimeConverter())

        val gson = gsonBuilder.create()


//     CLIENT


    }
}