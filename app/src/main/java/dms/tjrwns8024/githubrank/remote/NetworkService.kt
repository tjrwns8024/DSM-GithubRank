package dms.tjrwns8024.githubrank.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://52.79.253.30:5050")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createService() : Api = retrofit.create(Api::class.java)
}