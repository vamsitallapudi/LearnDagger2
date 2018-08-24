package com.coderefer.learndagger2

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(context: Context) {
var context:Context = context

    @Provides
    @GithubApplicationScope
    fun context() : Context {
        return context
    }

}