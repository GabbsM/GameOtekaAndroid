package com.gaby.gameotekaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.gaby.gameotekaapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter : GameAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()


    }

    private fun initUI() {
        getAllGames()
        val manager = GridLayoutManager(this,1)
        adapter =  GameAdapter()
        binding.rvGame.layoutManager = manager
        binding.rvGame.adapter = adapter

    }

    private fun getAllGames(){

        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<GameResponse> = retrofit.create(ApiService::class.java).givemeAllGames()
            if(myResponse.isSuccessful){
                val response :GameResponse? = myResponse.body()
                if(response !=null){
                    Log.i("Gaby",response.toString())
                    runOnUiThread{
                        adapter.updateList(response.results)
                    }
                }else{
                    Log.i("Gaby","No ha funcionado :(")
                }
            }
        }
    }

    private fun getRetrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}