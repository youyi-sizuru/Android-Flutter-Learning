package com.lifefighter.mix.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val newEngineButton = findViewById<MaterialButton>(R.id.newEngineButton)
        //每次都会创建一个新的引擎
        newEngineButton.setOnClickListener {
            startActivity(FlutterActivity.withNewEngine().build(this))
        }
        //使用在Application里缓存的引擎
        val cacheEngineButton = findViewById<MaterialButton>(R.id.cacheEngineButton)
        cacheEngineButton.setOnClickListener {
            startActivity(FlutterActivity.withCachedEngine("cache").build(this))
        }
    }
}