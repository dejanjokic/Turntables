package net.dejanjokic.turntables.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import net.dejanjokic.turntables.util.CustomTimberTree
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(CustomTimberTree())
    }
}