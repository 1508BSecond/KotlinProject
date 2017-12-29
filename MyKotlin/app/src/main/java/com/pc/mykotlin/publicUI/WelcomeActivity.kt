package com.pc.mykotlin.publicUI

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jaeger.library.StatusBarUtil
import com.pc.mykotlin.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        StatusBarUtil.setTransparent(this)
        //给图片设置属性动画
        var animatorX: ObjectAnimator = ObjectAnimator.ofFloat(wel_iv,"scaleX",0.1f,1.5f)
        var animatorY: ObjectAnimator = ObjectAnimator.ofFloat(wel_iv,"scaleY",0.1f,1.5f)
        //组合动画
        var animSet: AnimatorSet = AnimatorSet()
        animSet.play(animatorX).with(animatorY)
        animSet.setDuration(3000)
        animSet.start()

        //动画监听器
        animSet.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                var i: Intent = Intent(this@WelcomeActivity,MainActivity::class.java)
                startActivity(i)
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
    }
}
