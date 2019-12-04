package com.example.test40

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_start.setOnClickListener({ startFirstAnimation() })
    }


    private fun startFirstAnimation() {
        if (false) {
            val intent = Intent(applicationContext, MotionActivity::class.java)
            startActivity(intent)
            return
        }

        motion_layout_root.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                when (currentId) {
                    R.id.state_end1 -> {
                        motionLayout?.apply {
                            this.setTransition(R.id.state_end1, R.id.state_end2)
                            this.setTransitionDuration(1200)
                            this.transitionToEnd()
                        }
                    }
                    R.id.state_end2 -> {
                        motionLayout?.apply {
                            /*this.setTransition(R.id.state_end2, R.id.state_end3)
                            this.setTransitionDuration(3000)
                            this.transitionToEnd()*/
                            view_transition3.performClick()
                        }
                    }
                }
            }

        })
        if (true) {
            view_transition1.performClick()
            return
        }

        //motion_layout_root.transitionToEnd()
    }
}
