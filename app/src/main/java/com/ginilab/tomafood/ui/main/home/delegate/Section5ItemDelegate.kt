package com.ginilab.tomafood.ui.main.home.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.ui.main.home.adapter.HomeAdapter
import com.ginilab.tomafood.ui.main.home.response.Section5Restaurants
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.synthetic.main.landing_offers.view.*
import kotlinx.android.synthetic.main.landing_offers.view.ratings
import kotlinx.android.synthetic.main.landing_offers.view.tv_discount
import kotlinx.android.synthetic.main.landing_offers.view.tv_minorder
import kotlinx.android.synthetic.main.landing_offers.view.tv_rating
import kotlinx.android.synthetic.main.landing_offers.view.tv_subtitleName
import kotlinx.android.synthetic.main.landing_offers.view.tv_titleName
import kotlinx.android.synthetic.main.test_landing.view.*

class Section5ItemDelegate(private val onClick: HomeAdapter.CellListener): AbsListItemAdapterDelegate<Section5Restaurants, Cell, Section5ItemDelegate.Section5ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): Section5ItemHolder {

        return Section5ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.landing_offers,
                parent,
                false
            ), onClick
        )
    }

    override fun isForViewType(item: Cell, items: MutableList<Cell>, position: Int): Boolean {
        return item is Section5Restaurants

    }

    override fun onBindViewHolder(
        item: Section5Restaurants,
        holder: Section5ItemHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class Section5ItemHolder(
        itemView: View,
        private val cellListener: HomeAdapter.CellListener
    ) : RecyclerView.ViewHolder(itemView){

        private val visiblePercentage = 0.9

        fun bind(listItem: Section5Restaurants){

            with(itemView){

                tv_titleName.text = listItem.restaurant_name
                tv_subtitleName.text = listItem.restaurant_type
                ratings.rating = listItem.rating.toFloat()
                tv_rating.text = listItem.rating

                tv_minorder.text = "No Minimum Order"
                tv_discount.text = "25% minimum discount on each order"

            }
        }
    }


}