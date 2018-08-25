package com.coderefer.learndagger2

import com.coderefer.learndagger2.network.GithubService
import com.squareup.picasso.Picasso
import dagger.Component

@GithubApplicationScope
@Component(modules = [GithubServiceModule::class, PicassoModule::class, ActivityModule::class])
public interface GithubApplicationComponent {

    fun getPicasso(): Picasso
    fun getGithubService():GithubService

}