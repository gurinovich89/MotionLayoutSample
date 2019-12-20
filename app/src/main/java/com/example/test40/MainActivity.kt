package com.example.test40

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        //EdgeToEdge.apply(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            //val mainFragment = MainFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_container_id, SplashLoginFragment(), "1")
                .commitAllowingStateLoss()
        }

        setWindowTransparency { statusBarSize, bottomNavigationBarSize, leftNavigationBarSize, rightNavigationBarSize ->
            Log.i(
                "west statusbarSize=",
                "west statusbarSize=$statusBarSize bottomNavigationBarSize=$bottomNavigationBarSize"
            )
        }
        /*window.navigationBarColor = Color.TRANSPARENT
        window.statusBarColor = Color.TRANSPARENT*/
        /*ContextCompat.getColor(applicationContext, R.color.custom_status_bar_color)
    window.navigationBarColor =
        ContextCompat.getColor(applicationContext, R.color.custom_navigation_bar_color)*/
    }


}


object EdgeToEdge {

    @JvmStatic
    fun apply(activity: Activity) {
        val contentView = activity.findViewById<View>(android.R.id.content)
        contentView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

}
