package com.coderefer.learndagger2.screens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.coderefer.learndagger2.DaggerApplication
import com.coderefer.learndagger2.R
import com.coderefer.learndagger2.network.GithubService
import com.coderefer.learndagger2.screens.home.AdapterRepos
import com.coderefer.learndagger2.screens.home.DaggerHomeActivityComponent
import com.squareup.picasso.Picasso
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var adapterRepos: AdapterRepos
    @Inject
    lateinit var githubService:GithubService
    @Inject
    lateinit var picasso: Picasso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeActivityComponent = DaggerHomeActivityComponent.builder()
                .homeActivityModule(HomeActivityModule(this))
                .githubApplicationComponent(DaggerApplication.get(this).applicationComponent())
                .build()
        homeActivityComponent.injectHomeActivity(this)
    }
}
