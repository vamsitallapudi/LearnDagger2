package com.coderefer.learndagger2

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityModule(context: Activity) {
    var context: Context = context

    @Provides
    @GithubApplicationScope
    @Named("activity_context")
    fun context() : Context {
        return context
    }

}