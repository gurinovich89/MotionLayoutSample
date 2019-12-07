package com.example.test40

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_unregistered.*


class UnregisteredFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_unregistered, container, false)
    }

    var cacheStasusBarColor: Int? = null

    override fun onResume() {
        super.onResume()
        val window = activity?.getWindow()
        window?.apply {
            cacheStasusBarColor = window.statusBarColor
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(Color.RED)
        }
    }

    override fun onPause() {
        super.onPause()
        val window = activity?.getWindow()
        window?.apply {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            cacheStasusBarColor?.let {
                window.setStatusBarColor(it)
            }
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        motion_layout_root.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                val registerFragment = RegisterFragment()
                fragmentManager?.apply {
                    beginTransaction()
                        .setCustomAnimations(
                            R.anim.enter_from_right,
                            R.anim.exit_to_left,
                            R.anim.enter_from_left,
                            R.anim.exit_to_right
                        )
                        .replace(R.id.frame_container_id, registerFragment, "reg")
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
                }
            }
        })
        btn_start.setOnClickListener { motion_layout_root.transitionToEnd() }
        /*motionLayout.setTransition(R.id.base_state, R.id.half_people)
        motionLayout.setTransitionDuration(5000)
        motionLayout.transitionToEnd()*/
        //MotionLayout.Trans
    }
}
