package dms.tjrwns8024.githubrank.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dms.tjrwns8024.githubrank.R
import dms.tjrwns8024.githubrank.entity.RankInfo

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val rankItems = ArrayList<RankInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rank, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(rankItems[position], position)
        }
    }

    override fun getItemCount(): Int = rankItems.size

    fun setItems(item: ArrayList<RankInfo>){
        rankItems.addAll(item)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val rankTv = itemView.findViewById<TextView>(R.id.rank_tv)
        private val rankProfileImage = itemView.findViewById<ImageView>(R.id.rank_profile_image)
        private val rankNameTv = itemView.findViewById<TextView>(R.id.rank_name_tv)
        private val rankIdTv = itemView.findViewById<TextView>(R.id.rank_id_tv)
        private val rankCommitTv = itemView.findViewById<TextView>(R.id.rank_commit_tv)

        fun bind(item :RankInfo, position: Int){
            rankTv.text = (position+1).toString()
            rankNameTv.text = item.name
            rankIdTv.text = item.githubId
            rankCommitTv.text = item.contributions.toString()

            Glide.with(rankProfileImage)
                .load(item.githubImage)
                .into(rankProfileImage)
        }
    }

}