package com.coderefer.learndagger2.screens.home

import com.coderefer.learndagger2.GithubApplicationComponent
import com.coderefer.learndagger2.network.GithubService
import com.coderefer.learndagger2.screens.HomeActivity
import com.coderefer.learndagger2.screens.HomeActivityModule
import com.squareup.picasso.Picasso
import dagger.Component

@Component(modules =  [HomeActivityModule::class], dependencies = [GithubApplicationComponent::class])
@HomeActivityScope
interface HomeActivityComponent {

    fun injectHomeActivity(homeActivity:HomeActivity)

}