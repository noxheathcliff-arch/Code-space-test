package com.izumih.flowreply

import android.app.Application
import com.izumih.flowreply.data.PreferencesManager
import com.izumih.flowreply.util.NotificationHelper

/**
 * Application entry point. Holds process-wide singletons (lightweight manual DI,
 * which keeps the build simple and dependency-free).
 */
class FlowReplyApplication : Application() {

    val preferencesManager: PreferencesManager by lazy { PreferencesManager(this) }

    override fun onCreate() {
        super.onCreate()
        instance = this
        NotificationHelper.createChannels(this)
    }

    companion object {
        lateinit var instance: FlowReplyApplication
            private set
    }
}
