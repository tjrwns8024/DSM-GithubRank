package dms.tjrwns8024.githubrank.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dms.tjrwns8024.githubrank.R
import dms.tjrwns8024.githubrank.databinding.ItemMedalRankBinding
import dms.tjrwns8024.githubrank.entity.RankInfo

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val rankItems = ArrayList<RankInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_medal_rank, parent, false)
            RankMedalViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_rank, parent, false)
            MedalViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RankMedalViewHolder) {
            holder.bind(rankItems[position], position)
        } else if( holder is MedalViewHolder ) {
            holder.bind(rankItems[position], position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position < 3) {
            return 1
        } else return 2
    }

    override fun getItemCount(): Int = rankItems.size

    fun setItems(item: ArrayList<RankInfo>) {
        rankItems.addAll(item)
        notifyDataSetChanged()
    }

    inner class RankMedalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val rankTv = itemView.findViewById<TextView>(R.id.rank_medal_tv)
        private val rankMedalImage = itemView.findViewById<ImageView>(R.id.rank_medal_image)
        private val rankProfileImage =
            itemView.findViewById<ImageView>(R.id.rank_profile_medal_image)
        private val rankNameTv = itemView.findViewById<TextView>(R.id.rank_name_medal_tv)
        private val rankIdTv = itemView.findViewById<TextView>(R.id.rank_id_medal_tv)
        private val rankCommitTv = itemView.findViewById<TextView>(R.id.rank_commit_medal_tv)

        fun bind(item: RankInfo, position: Int) {
            val rank = position + 1
            rankTv.text = rank.toString()
            rankNameTv.text = item.name
            rankIdTv.text = item.githubId
            rankCommitTv.text = item.contributions.toString()

            Glide.with(rankProfileImage)
                .load(item.githubImage)
                .into(rankProfileImage)

            when (rankItems.indexOf(item)) {
                0 -> rankMedalImage.setImageResource(R.drawable.ic_gold_medal)
                1 -> rankMedalImage.setImageResource(R.drawable.ic_silver_medal)
                2 -> rankMedalImage.setImageResource(R.drawable.ic_bronze_medal)
            }
        }
    }

    inner class MedalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val rankTv = itemView.findViewById<TextView>(R.id.rank_tv)
        private val rankProfileImage = itemView.findViewById<ImageView>(R.id.rank_profile_image)
        private val rankNameTv = itemView.findViewById<TextView>(R.id.rank_name_tv)
        private val rankIdTv = itemView.findViewById<TextView>(R.id.rank_id_tv)
        private val rankCommitTv = itemView.findViewById<TextView>(R.id.rank_commit_tv)

        fun bind(item: RankInfo, position: Int) {
            val rank = position + 1
            rankTv.text = rank.toString()
            rankNameTv.text = item.name
            rankIdTv.text = item.githubId
            rankCommitTv.text = item.contributions.toString()

            Glide.with(rankProfileImage)
                .load(item.githubImage)
                .into(rankProfileImage)
        }
    }
}