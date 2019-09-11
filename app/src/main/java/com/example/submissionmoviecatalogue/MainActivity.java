package com.example.submissionmoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

/*
Structure
MovieParcelable.java => MovieParcelableAdapter.java
activity_main.xml => MainActivity.java, MovieParelableAdapter.java => list_film.xml
detail_film.xml => DetailMovie.java
*/

    /* Declarasi String, Array & Adapter */

    private TypedArray dataImgMovie;
    private String[] dataTitleMovie;
    private String[] dataOverviewMovie;
    private String[] dataRuntimeMovie;

    private ArrayList<MovieParcelable> movieParcelableArrayList;

    private RecyclerView MovieRecyclerView;
    private MovieParcelableAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Registry function adapter pada MovieParcelable.class */
        adapter = new MovieParcelableAdapter(this);

        ListView listView = findViewById(R.id.lv_daftar_film);
        listView.setAdapter(adapter);

        /* Create new function prepare & additem untuk mengambil nilai array ada MovieParcelable.class */
        prepare();
        addItem();


        /* Function OnItemClick Adapter Move Activity On MainActivity.java to DetailMoview.java */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentDetailMovie = new Intent(MainActivity.this, DetailMovie.class);
                intentDetailMovie.putExtra(DetailMovie.EXTRA_MovieParcelable, movieParcelableArrayList.get(i));
                startActivity(intentDetailMovie);
            }
        });
    }

    /* function prepare untuk mengambil nilai array ada MovieParcelable.class */
    private void prepare() {

        dataImgMovie = getResources().obtainTypedArray(R.array.data_img_movie);
        dataTitleMovie = getResources().getStringArray(R.array.data_title_movie);
        dataOverviewMovie = getResources().getStringArray(R.array.data_overview_movie);
        dataRuntimeMovie = getResources().getStringArray(R.array.data_runtime_movie);

    }


    /* function addItem untuk menampilkan hasil dari MovieParcelable.class */
    private void addItem() {
        movieParcelableArrayList = new ArrayList<>();

        for (int i = 0; i < dataTitleMovie.length; i++) {
            MovieParcelable movieParcelable = new MovieParcelable();

            movieParcelable.setImg_movie(dataImgMovie.getResourceId(i, -1));
            movieParcelable.setTitle_movie(dataTitleMovie[i]);
            movieParcelable.setOverview_movie(dataOverviewMovie[i]);
            movieParcelable.setRuntime_movie(dataRuntimeMovie[i]);

            movieParcelableArrayList.add(movieParcelable);

        }

        adapter.setMovieParcelableArrayList(movieParcelableArrayList);

    }


}