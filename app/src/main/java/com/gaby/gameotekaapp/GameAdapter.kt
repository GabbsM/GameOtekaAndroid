package com.gaby.gameotekaapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GameAdapter (var gameList: List<GameItemResponse> = emptyList()):
    RecyclerView.Adapter<GameReviewHolder>() {

    fun updateList(gameList: List<GameItemResponse>){
        this.gameList = gameList
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameReviewHolder {
            return GameReviewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_game,parent,false)
            )
    }

    override fun getItemCount(): Int = gameList.size

    override fun onBindViewHolder(holder: GameReviewHolder, position: Int) {
            holder.render(gameList[position])
    }
}