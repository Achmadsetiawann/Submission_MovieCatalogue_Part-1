package com.example.submissionmoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

/*
Structure

MovieParcelable.java => MovieParcelableAdapter.java
activity_main.xml => MainActivity.java, MovieParelableAdapter.java => list_film.xml

*/

    /* Declarasi String, Array & Adapter */
    private TypedArray dataImgMovie;
    private String[] dataTitleMovie;
    private String[] dataOverviewMovie;
    private String[] dataRuntimeMovie;
    private MovieParcelableAdapter adapter;
    private ArrayList<MovieParcelable> movieParcelableArrayList;

    /*private String[] dataGendreMovie;
    private String[] dataBudgetMovie;
    private String[] dataRevenueMovie;
    private String[] dataReviewMovie;*/

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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movieParcelableArrayList.get(i).getTitle_movie(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* function prepare untuk mengambil nilai array ada MovieParcelable.class */
        private void prepare() {

            dataImgMovie = getResources().obtainTypedArray(R.array.data_img_movie);
            dataTitleMovie = getResources().getStringArray(R.array.data_title_movie);
            dataOverviewMovie = getResources().getStringArray(R.array.data_overview_movie);
            dataRuntimeMovie = getResources().getStringArray(R.array.data_runtime_movie);

            /*dataGendreMovie = getResources().getStringArray(R.array.data_gendre_movie);
            dataBudgetMovie = getResources().getStringArray(R.array.data_budget_movie);
            dataRevenueMovie = getResources().getStringArray(R.array.data_revenue_movie);
            dataReviewMovie = getResources().getStringArray(R.array.data_review_movie);*/

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

                /*movieParcelable.setGendre_movie(dataGendreMovie[i]);
                movieParcelable.setBudget_movie(dataBudgetMovie[i]);
                movieParcelable.setRevenue_movie(dataRevenueMovie[i]);
                movieParcelable.setReview_movie(dataReviewMovie[i]);*/

            }

            adapter.setMovieParcelableArrayList(movieParcelableArrayList);

        }



}



