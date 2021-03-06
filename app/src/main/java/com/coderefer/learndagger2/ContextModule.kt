package com.coderefer.learndagger2

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ContextModule(context: Context) {
var context:Context = context.applicationContext

    @Provides
    @GithubApplicationScope
    @ApplicationContext
    fun context() : Context {
        return context
    }

}