package com.coderefer.learndagger2

import android.app.Activity
import android.app.Application
import timber.log.Timber

class DaggerApplication : Application() {
    private lateinit var githubApplicationComponent: GithubApplicationComponent
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        githubApplicationComponent = DaggerGithubApplicationComponent.builder()
                .contextModule(ContextModule(this))
                .build()

        val githubService = githubApplicationComponent.getGithubService()
        val picasso = githubApplicationComponent.getPicasso()
        val githubService2 = githubApplicationComponent.getGithubService()
        val picasso2 = githubApplicationComponent.getPicasso()
        val githubService3 = githubApplicationComponent.getGithubService()
        val picasso3 = githubApplicationComponent.getPicasso()

        Timber.tag("Dagger2 ").i("githubservice:$githubService")
        Timber.tag("Dagger2 ").i("picasso:$picasso")
        Timber.tag("Dagger2 ").i("githubservice2:$githubService2")
        Timber.tag("Dagger2 ").i("picasso2:$picasso2")
        Timber.tag("Dagger2 ").i("githubservice3:$githubService3")
        Timber.tag("Dagger2 ").i("picasso3:$picasso3")
    }

    fun applicationComponent():GithubApplicationComponent {
        return githubApplicationComponent
    }


    companion object {
        fun get(activity: Activity): DaggerApplication {
            return activity.application as DaggerApplication
        }
    }
}