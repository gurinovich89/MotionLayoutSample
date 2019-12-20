package com.example.test40

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main_pincode.motion_layout_root
import kotlinx.android.synthetic.main.fragment_splash_login.*


class SplashLoginFragment : Fragment() {

    lateinit var motionLayout: MotionLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        motionLayout = view.findViewById(R.id.motion_layout_root)
        motionLayout.setOnClickListener { v ->
            val index = etState.text.toString().toIntOrNull() ?: 1
            setMotionLayoutState(index)
        }
    }

    override fun onResume() {
        super.onResume()
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                Log.i("west", "onTransitionCompleted currentId=$currentId")
                if (currentId == R.id.set_2) {
                    //motion_layout_root.transitionToState(R.id.state_3)
                }
            }
        })
    }

    private fun setMotionLayoutState(index: Int) {
        val stateId = getStateIdByIndex(index)
        Log.i(
            "west",
            "transitionToState currentState=${motion_layout_root.currentState} toStateId=$stateId"
        )

        val prevStateId = getStateIdByIndex(index - 1)
        motionLayout.setState(prevStateId, -1, -1)
        motionLayout.transitionToState(stateId)
    }

    fun getStateIdByIndex(index: Int): Int {
        val stateId = when (index) {
            0 -> R.id.state_0
            1 -> R.id.state_1
            2 -> R.id.state_2
            3 -> R.id.state_3
            4 -> R.id.state_4
            5 -> R.id.state_5
            else -> throw RuntimeException("cannot find state id")
        }
        return stateId
    }
}
