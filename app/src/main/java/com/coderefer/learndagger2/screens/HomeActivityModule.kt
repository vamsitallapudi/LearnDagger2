package com.coderefer.learndagger2.screens

import com.coderefer.learndagger2.screens.home.HomeActivityScope
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule (homeActivity: HomeActivity){
    private val homeActivity = homeActivity

//    @Provides
//    @HomeActivityScope
//    fun adapterRepos(picasso: Picasso): AdapterRepos{
//        return AdapterRepos(homeActivity,picasso)
//    }

    @Provides
    @HomeActivityScope
    fun homeActivity(picasso: Picasso): HomeActivity{
        return homeActivity
    }

}