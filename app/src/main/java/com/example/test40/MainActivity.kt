package com.example.test40

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val mainFragment = MainFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_container_id, mainFragment, "1")
                .commitAllowingStateLoss()
        }
        /*window.statusBarColor = Color.GREEN
        window.navigationBarColor = Color.RED*/
    }
}
