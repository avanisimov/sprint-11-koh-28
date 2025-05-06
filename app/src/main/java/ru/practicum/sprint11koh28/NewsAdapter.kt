package ru.practicum.sprint11koh28

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.DateFormat

class NewsAdapter : RecyclerView.Adapter<NewsItemViewHolder>() {

    var items: List<NewsItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        return NewsItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(items[position])
    }
}


class NewsItemViewHolder(
    parentView: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parentView.context)
        .inflate(R.layout.v_news_item, parentView, false)
) {

    private val title: TextView = itemView.findViewById(R.id.title)
    private val created: TextView = itemView.findViewById(R.id.created)
    private val sportTeams: TextView = itemView.findViewById(R.id.sport_teams)
    private val scienceImg: ImageView = itemView.findViewById(R.id.science_img)

    fun bind(item: NewsItem) {
        title.text = item.title
        created.text =
            DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT
            ).format(item.created)

        when (item) {
            is NewsItem.Science -> {
                Glide.with(scienceImg)
                    .load(item.specificPropertyForScience)
                    .into(scienceImg)
                scienceImg.isVisible = true
            }
            is NewsItem.Sport -> {
                sportTeams.text = item.specificPropertyForSport
                sportTeams.isVisible = true
            }
        }
    }
}