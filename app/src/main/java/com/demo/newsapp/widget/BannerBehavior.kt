package com.demo.newsapp.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.demo.newsapp.utils.logd

class BannerBehavior(context: Context? = null, attrs: AttributeSet? = null) :
    CoordinatorLayout.Behavior<ViewPager2>(context, attrs) {

    private var upReach = false
    private var downReach = false
    private var lastPosition = 0F

    override fun onInterceptTouchEvent(
        parent: CoordinatorLayout,
        child: ViewPager2,
        ev: MotionEvent
    ): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                downReach = false
                upReach = false
            }
        }
        return super.onInterceptTouchEvent(parent, child, ev)
    }

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: ViewPager2,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: ViewPager2,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
        if (target is RecyclerView) {
            if (dy > 0 && child.translationY.toInt() == -child.height) {
                // 如果向上滑，并且banner已经全部隐藏。交给recyclerview
                return
            } else if (dy < 0 && target.canScrollVertically(-1)) {
                // 如果向下滑动，但是recyclerview还没有到顶，交给recyclerview
                return
            }

            val bannerY = child.translationY
            if (bannerY <= 0 && bannerY >= -child.height) {
                var tempTranY = lastPosition - dy.toFloat()
                if (tempTranY > 0) {
                    tempTranY = 0F
                } else if (tempTranY < -child.height) {
                    tempTranY = -child.height.toFloat()
                }
                child.translationY = tempTranY
                consumed[1] = dy
            }
            lastPosition = child.translationY
        }
    }
}