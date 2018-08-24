package com.coderefer.learndagger2

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File

@Module(includes = [ContextModule::class])
class NetworkModule {

    @Provides
    @GithubApplicationScope
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {

        val httpLoggingInterceptor =  HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Timber.i(it)
        })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return httpLoggingInterceptor
    }

    @Provides
    @GithubApplicationScope
    fun cache(cacheFile: File): Cache {
        return  Cache(cacheFile, 10*1024*1024/* 10 MB cache*/)
    }

    @Provides
    @GithubApplicationScope
    fun cacheFile(context: Context): File {
        val cacheFile = File(context.cacheDir,"okhttp_cache")
        cacheFile.mkdirs()
        return cacheFile
    }

    @Provides
    @GithubApplicationScope
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, cache: Cache) : OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build()
    }
}