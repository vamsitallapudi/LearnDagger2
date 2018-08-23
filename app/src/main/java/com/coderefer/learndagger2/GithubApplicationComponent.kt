package com.coderefer.learndagger2

import com.coderefer.learndagger2.network.GithubService
import com.squareup.picasso.Picasso
import dagger.Component

@Component(modules = [GithubServiceModule::class])
public interface GithubApplicationComponent {

    fun getPicasso(): Picasso
    fun getGithubService():GithubService

}