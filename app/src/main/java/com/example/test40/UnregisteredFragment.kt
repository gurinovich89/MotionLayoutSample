package com.example.test40

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
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
        cacheStasusBarColor = activity?.window?.statusBarColor
        setStatusBarColor(ContextCompat.getColor(context!!, R.color.color_splash_end))
    }

    override fun onPause() {
        super.onPause()
        cacheStasusBarColor?.let { setStatusBarColor(it) }
    }

    fun setStatusBarColor(color: Int) {
        val window = activity?.window
        window?.apply {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = color
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setTranslationZ(view, 100f);
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
                        .replace(R.id.frame_container_id, registerFragment, "reg")
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
                    tintSystemBars()
                }
            }
        })
        motion_layout_root.progress = 0.5f
        btn_start.setOnClickListener {
            //motion_layout_root.setInterpolatedProgress(0.5f)
            motion_layout_root.transitionToEnd()
        }
        /*motionLayout.setTransition(R.id.base_state, R.id.half_people)
        motionLayout.setTransitionDuration(5000)
        motionLayout.transitionToEnd()*/
        //MotionLayout.Trans
    }

    private fun tintSystemBars() { // Initial colors of each system bar.
        val statusBarColor = resources.getColor(R.color.color_splash_end)
        // Desired final colors of each bar.
        val statusBarToColor = Color.BLUE
        val anim = ValueAnimator.ofFloat(0f, 1f)
        anim.addUpdateListener { animation ->
            // Use animation position to blend colors.
            val position = animation.animatedFraction
            // Apply blended color to the status bar.
            var blended = blendColors(statusBarColor, statusBarToColor, position)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                activity?.window?.setStatusBarColor(blended)
            }

        }
        anim.setDuration(1000).start()
    }

    private fun blendColors(from: Int, to: Int, ratio: Float): Int {
        val inverseRatio = 1f - ratio
        val r: Float = Color.red(to) * ratio + Color.red(from) * inverseRatio
        val g: Float = Color.green(to) * ratio + Color.green(from) * inverseRatio
        val b: Float = Color.blue(to) * ratio + Color.blue(from) * inverseRatio
        return Color.rgb(r.toInt(), g.toInt(), b.toInt())
    }
}
