package dms.tjrwns8024.githubrank.main

import dms.tjrwns8024.githubrank.base.BaseContract
import dms.tjrwns8024.githubrank.entity.RankInfo

interface MainContract {

    interface View : BaseContract.View {
        fun setItems(item: ArrayList<RankInfo>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData()
    }
}