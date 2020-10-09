package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Holder> {

    Context c;
    ArrayList<Model> models;

    public Adapter(Context c, ArrayList<Model> models){
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_mockup, null);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.mMusicNAme.setText(models.get(i).getMusicName());
        holder.mArtist.setText(models.get(i).getArtist());
        holder.mDuration.setText(models.get(i).getDuration());

        holder.setItemClickListener(new Holder.ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                String gMusicName = models.get(position).getMusicName();
                String gArtist = models.get(position).getArtist();
                String gDuration = models.get(position).getDuration();


                Intent intent = new Intent(c, MainActivity.class);
                        c.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
