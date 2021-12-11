package com.lifefighter.mix.android

import android.app.Application
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 创建一个flutter引擎缓存下来
        val cacheFlutterEngine = FlutterEngine(this)
        val flutterLoader = FlutterInjector.instance().flutterLoader()
        cacheFlutterEngine.dartExecutor.executeDartEntrypoint(
            DartEntrypoint(
                flutterLoader.findAppBundlePath(),
                "cache"
            )
        )
        FlutterEngineCache.getInstance().put("cache", cacheFlutterEngine)
    }
}