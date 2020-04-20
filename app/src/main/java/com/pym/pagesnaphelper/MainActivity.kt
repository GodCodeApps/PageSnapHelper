package com.pym.pagesnaphelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var screenWidth = window.windowManager.defaultDisplay.width
        val marg = screenWidth / 60
        var itemWidth = (screenWidth - marg * 12) / 6
        var gridlayoutmanager = PagerGridLayoutManager(5, 6, PagerGridLayoutManager.HORIZONTAL)
        recycleView1.layoutManager = gridlayoutmanager
        val pagerGridSnapHelper = PagerGridSnapHelper()
        pagerScrollBar.attachToRecyclerView(recycleView1)
        pagerScrollBar.setTotalPageSize(2, screenWidth, marg)
        pagerGridSnapHelper.attachToRecyclerView(recycleView1)
        recycleView1?.adapter = SimpAdapter(itemWidth, marg)
    }
}
