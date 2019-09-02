package com.example.submissionmoviecatalogue;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class DetailMovie extends AppCompatActivity{

    private RecyclerView listMovieDetail;
    private ArrayList<MovieParcelable> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_film);


        listMovieDetail = findViewById(R.id.detail_film);
        listMovieDetail.setHasFixedSize(true);

        list.addAll(MovieParcelableAdapter.getLis());
        showRecyclerList();

    }


    private void showRecyclerList(){
        listMovieDetail.setLayoutManager(new LinearLayoutManager(this));
        DetailMovieAdapter listMovieAdapter = new DetailMovieAdapter(list);
        listMovieDetail.setAdapter(listMovieAdapter);
    }



}

