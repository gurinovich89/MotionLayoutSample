package com.example.test40

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.motion_multistate_layout.*

class MotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_multistate_layout)
        motionLayout.setTransition(R.id.base_state, R.id.half_people)
        motionLayout.setTransitionDuration(5000)
        motionLayout.transitionToEnd()
        //MotionLayout.Trans
    }
}
