package com.demo.newsapp.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.demo.newsapp.utils.logi

class RecyclerViewBehavior(context: Context? = null, attrs: AttributeSet? = null) :
    CoordinatorLayout.Behavior<RecyclerView>(context, attrs) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: RecyclerView,
        dependency: View
    ): Boolean {
        return (dependency is ViewPager2)
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: RecyclerView,
        dependency: View
    ): Boolean {
        var y = dependency.height + dependency.translationY
        if (y < 0) {
            y = 0F
        }
        child.y = y
        return true
    }
}