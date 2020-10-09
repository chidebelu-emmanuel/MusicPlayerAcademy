package com.example.musicplayer;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView mMusicNAme, mArtist, mDuration;
    ItemClickListener itemClickListener;

    public Holder(@NonNull View itemView) {
        super(itemView);

        this.mMusicNAme = itemView.findViewById(R.id.musicname);
        this.mArtist = itemView.findViewById(R.id.artist);
        this.mDuration = itemView.findViewById(R.id.duration);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClickListener(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }
    public interface ItemClickListener {

        void onItemClickListener(View view, int position);
    }
}
