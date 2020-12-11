package dms.tjrwns8024.githubrank.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dms.tjrwns8024.githubrank.R
import dms.tjrwns8024.githubrank.adapter.MainAdapter
import dms.tjrwns8024.githubrank.databinding.ActivityMainBinding
import dms.tjrwns8024.githubrank.entity.RankInfo

class MainActivity : AppCompatActivity(), MainContract.View, SwipeRefreshLayout.OnRefreshListener {
    private val presenter by lazy { MainPresenter(this) }
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adapter = MainAdapter()

        binding.rankRv.layoutManager = LinearLayoutManager(this)
        binding.rankRv.adapter = adapter
        binding.rankSwipeLayout.setOnRefreshListener(this)


        setContentView(binding.root)

        presenter.loadData()
    }

    override fun setItems(item: ArrayList<RankInfo>) {
        adapter.setItems(item)
    }

    override fun onRefresh() {
        presenter.loadData()

        binding.rankSwipeLayout.isRefreshing = false
    }
}