package com.coderefer.learndagger2

import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [ContextModule::class, NetworkModule::class])
class PicassoModule {

    @Provides
    @GithubApplicationScope
    fun picasso(context: Context, okHttp3Downloader: OkHttp3Downloader):Picasso {
        return  Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build()
    }

    @Provides
    @GithubApplicationScope
    fun okHttp3Downloader(okHttpClient: OkHttpClient):OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }
}