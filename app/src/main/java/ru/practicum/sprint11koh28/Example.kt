package ru.practicum.sprint11koh28

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ForecastAdapter(
    val clickListener: ForecastClickListener
) : RecyclerView.Adapter<ViewHolder>() {

    val items = mutableListOf(ForecastItem())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { clickListener.onForecastClick(items[position]) }
    }


    fun interface ForecastClickListener {
        fun onForecastClick(item: ForecastItem)
    }


}

class ForecastItem()

val adapter1 = ForecastAdapter(ForecastClickListenerImpl())
val adapter2 = ForecastAdapter(object: ForecastAdapter.ForecastClickListener{
    override fun onForecastClick(item: ForecastItem) {
        show(item)
    }
})
val adapter3 = ForecastAdapter({
    show(it)
})
val adapter4 = ForecastAdapter({ item ->
    show(item)
})
val adapter5 = ForecastAdapter {
    show(it)
}

class ForecastClickListenerImpl: ForecastAdapter.ForecastClickListener {
    override fun onForecastClick(item: ForecastItem) {
        show(item)
    }

}

fun show(item: ForecastItem) {

}