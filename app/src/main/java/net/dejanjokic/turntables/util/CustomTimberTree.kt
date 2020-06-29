package net.dejanjokic.turntables.util

import timber.log.Timber

class CustomTimberTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String =
        "(${element.fileName}:${element.lineNumber})#${element.methodName}"
}