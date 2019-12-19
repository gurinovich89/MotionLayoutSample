package com.example.test40

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main_pincode.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_pincode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_launch_full_anim.setOnClickListener({ startFullAnimation() })
        btn_unregister_screen.setOnClickListener({ openUnregistredFragment() })
        tv_user.text = "Alexander"
        tv_show_progress.setOnClickListener {
            setMotionLayoutState()
        }
    }

    override fun onStart() {
        super.onStart()
        motion_layout_root.progress = 1f
        motion_layout_root.transitionToState(R.id.state_2)
    }

    override fun onResume() {
        super.onResume()
        //motion_layout_root.transitionToState(R.id.state_3)
    }

    private fun setMotionLayoutState() {
        motion_layout_root.transitionToState(R.id.state_2)
        //motion_layout_root.setState(R.id.state_1, -1, -1)
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
                if (currentId == R.id.set_2) {
                    motion_layout_root.transitionToState(R.id.state_3)
                }
            }
        })
        motion_layout_root.transitionToState(R.id.state_1)
        //motion_layout_root.setTransitionDuration(5000)
        //motion_layout_root.setTransition(R.id.state_3, R.id.state_2)
    }


    private fun openUnregistredFragment() {
        val unregisteredFragment = UnregisteredFragment()
        fragmentManager?.apply {
            beginTransaction()
                .setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.do_nothing, //R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                )
                .replace(R.id.frame_container_id, unregisteredFragment, "unreg")
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }
    }
}
