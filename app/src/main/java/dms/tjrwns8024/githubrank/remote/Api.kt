package dms.tjrwns8024.githubrank.remote

import dms.tjrwns8024.githubrank.entity.ResponseRank
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/rank")
    fun getRank(): Call<ResponseRank>
}