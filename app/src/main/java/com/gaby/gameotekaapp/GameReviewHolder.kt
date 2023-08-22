package com.gaby.gameotekaapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gaby.gameotekaapp.databinding.ItemGameBinding
import com.squareup.picasso.Picasso

class GameReviewHolder (view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemGameBinding.bind(view)

        fun render(gameItemResponse: GameItemResponse){
        binding.tvName.text = gameItemResponse.name
        Picasso.get().load(gameItemResponse.image).into(binding.ivGame)
    }
}