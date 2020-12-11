package dms.tjrwns8024.githubrank.main

import android.util.Log
import dms.tjrwns8024.githubrank.entity.ResponseRank
import dms.tjrwns8024.githubrank.remote.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    override fun releaseView() {
        TODO("Not yet implemented")
    }

    override fun loadData() {
        val response: Call<ResponseRank> = NetworkService.createService().getRank()

        response.enqueue(object: Callback<ResponseRank>{
            override fun onResponse(call: Call<ResponseRank>, response: Response<ResponseRank>) {
                Log.d("code",response.code().toString())
                    view.setItems(response.body()!!.rank)

            }

            override fun onFailure(call: Call<ResponseRank>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

        })
    }
}