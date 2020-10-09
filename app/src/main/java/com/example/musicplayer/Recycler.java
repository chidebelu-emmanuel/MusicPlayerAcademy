package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(this, getMyList());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Model> getMyList() {
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setMusicName("Abule");
        m.setArtist("Patoranking");
        m.setDuration("04:03");
        models.add(m);

        m = new Model();
        m.setMusicName("Ekwueme");
        m.setArtist("Osinachi");
        m.setDuration("03:46");
        models.add(m);

        m = new Model();
        m.setMusicName("billy jean");
        m.setArtist("Michael Jackson");
        m.setDuration("02:45");
        models.add(m);

        m = new Model();
        m.setMusicName("Forever Young");
        m.setArtist("J_zay ft Hudson");
        m.setDuration("04:00");
        models.add(m);



        return models;
    }
}