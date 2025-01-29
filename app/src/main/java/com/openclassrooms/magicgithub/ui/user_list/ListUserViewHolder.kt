package com.openclassrooms.magicgithub.ui.user_list

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User

class ListUserViewHolder(private val binding: ItemListUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User, callback: UserListAdapter.Listener) {
        Glide.with(binding.root.context)
            .load(user.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.default_avatar) // Image temporaire
            .error(R.drawable.default_avatar)
            .into(binding.itemListUserAvatar)

        binding.itemListUserUsername.text = user.login

        // Changer la couleur du fond selon l'état de l'utilisateur
        if (user.isActive) {
            binding.root.setBackgroundColor(Color.WHITE)
        } else {
            binding.root.setBackgroundColor(Color.RED)
        }

        binding.itemListUserDeleteButton.setOnClickListener {
            callback.onClickDelete(user)
        }
    }
}
