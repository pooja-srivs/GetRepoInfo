package com.ginilab.tomafood.ui.main.kishan.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.base.extensions.loadCircularImage
import com.ginilab.tomafood.model.TrendingResponse
import com.ginilab.tomafood.ui.main.kishan.adapter.TrendingAdapter
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.synthetic.main.trending_row_item.view.*

class TrendingDelegate(private val listener: TrendingAdapter.CellListener) :
    AbsListItemAdapterDelegate<TrendingResponse, Cell, TrendingDelegate.TrendingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): TrendingViewHolder {
        return TrendingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.trending_row_item,
                parent,
                false
            )
        )
    }

    override fun isForViewType(item: Cell, items: MutableList<Cell>, position: Int): Boolean {
        return item is TrendingResponse
    }

    override fun onBindViewHolder(
        item: TrendingResponse,
        holder: TrendingViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    inner class TrendingViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(trending: TrendingResponse) {

            with(itemView) {
                userImage.loadCircularImage(trending.avatar)
                authorName.text = trending.author
                repoName.text = trending.name

                repoDescription.text = trending.url
                repoLanguage.text = trending.language
                repoStar.text= trending.stars.toString()
                repoFork.text = trending.forks.toString()
                setOnClickListener {
                    if(contentGroup.isVisible){
                        contentGroup.visibility = View.GONE
                    }else{
                        contentGroup.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}