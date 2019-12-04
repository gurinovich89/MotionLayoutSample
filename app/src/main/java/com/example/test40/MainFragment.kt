package com.example.test40

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_launch_full_anim.setOnClickListener({ startFullAnimation() })
        btn_unregister_screen.setOnClickListener({ openUnregistredFragment() })
    }

    private fun startFullAnimation() {
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
                            view_transition3.performClick()
                        }
                    }
                }
            }

        })

        view_transition1.performClick()
    }


    private fun openUnregistredFragment() {
        val unregisteredFragment = UnregisteredFragment()
        fragmentManager?.apply {
            beginTransaction()
                .add(R.id.frame_container_id, unregisteredFragment, "unreg")
                .commitAllowingStateLoss()
        }
    }
}
