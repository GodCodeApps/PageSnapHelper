package com.pym.pagesnaphelper

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.scroll_bar_layout.view.*

class PagerScrollBar : LinearLayout {
    var totalSize: Int = 0
    var lineWidth: Int = 0

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        LayoutInflater.from(context).inflate(R.layout.scroll_bar_layout, this)


    }

    fun attachToRecyclerView(recyclerView: RecyclerView) {
        if (recyclerView?.layoutManager is PagerGridLayoutManager) {
            (recyclerView?.layoutManager as PagerGridLayoutManager).setPageListener(object :
                PagerGridLayoutManager.PageListener {
                override fun onPageSelect(pageIndex: Int) {
                    setLineLayout(pageIndex)
                }

                override fun onPageSizeChanged(pageSize: Int) {
                }
            })
        }
    }

    fun setTotalPageSize(totalSize: Int, screenWidth: Int, marg: Int) {
        this.totalSize = totalSize
        lineWidth = ((screenWidth - marg * 2) / totalSize)
        var scrollBarLayoutParams = scrollBar.layoutParams as FrameLayout.LayoutParams
        scrollBarLayoutParams.setMargins(marg, 0, marg, 0)
        val layoutParams = line?.layoutParams as LayoutParams
        layoutParams.width = lineWidth
        line?.layoutParams = layoutParams
        setLineLayout(0)

    }

    fun setLineLayout(index: Int) {
        var layoutParams = line?.layoutParams as LinearLayout.LayoutParams
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            layoutParams.marginStart = (lineWidth * index)
            line?.layoutParams = layoutParams
        }
    }
}