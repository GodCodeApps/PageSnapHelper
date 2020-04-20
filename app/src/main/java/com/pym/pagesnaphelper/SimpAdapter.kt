package com.pym.pagesnaphelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class SimpAdapter(var itemWidth: Int, var marg: Int) : RecyclerView.Adapter<VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return 31
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.tvText.text = "$position"
        val layoutParams = holder.itemView.tvText.layoutParams as FrameLayout.LayoutParams
        layoutParams.width = itemWidth
        layoutParams.height = itemWidth
        layoutParams.setMargins(marg, marg, marg, marg)
    }
}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
