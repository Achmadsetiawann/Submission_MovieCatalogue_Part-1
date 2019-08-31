package com.example.submissionmoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.os.Looper.prepare;


public class MainActivity extends AppCompatActivity{

/*
Structure

MovieParcelable.java => MovieParcelableAdapter.java
MainActivity.java => activity_main.xml => MovieParelableAdapter.java => DetailMovie.java

*/

    private TypedArray dataImgMovie;
    private String[] dataTitleMovie;
    private String[] dataOverviewMovie;
    private String[] dataGendreMovie;
    private String[] dataRuntimeMovie;
    private String[] dataBudgetMovie;
    private String[] dataRevenueMovie;
    private String[] dataReviewMovie;
    private MovieParcelableAdapter adapter;
    private ArrayList<MovieParcelable> movieParcelableArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieParcelableAdapter(this);

        ListView listView = findViewById(R.id.lv_daftar_film);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movieParcelableArrayList.get(i).getTitle_movie(), Toast.LENGTH_SHORT).show();
            }
        });
    }

        private void prepare() {

            dataImgMovie = getResources().obtainTypedArray(R.array.data_img_movie);
            dataTitleMovie = getResources().getStringArray(R.array.data_title_movie);
            dataOverviewMovie = getResources().getStringArray(R.array.data_overview_movie);
            dataGendreMovie = getResources().getStringArray(R.array.data_gendre_movie);
            dataRuntimeMovie = getResources().getStringArray(R.array.data_runtime_movie);
            dataBudgetMovie = getResources().getStringArray(R.array.data_budget_movie);
            dataRevenueMovie = getResources().getStringArray(R.array.data_revenue_movie);
            dataReviewMovie = getResources().getStringArray(R.array.data_review_movie);

        }

        private void addItem() {
            movieParcelableArrayList = new ArrayList<>();

            for (int i = 0; i < dataTitleMovie.length; i++) {
                MovieParcelable movieParcelable = new MovieParcelable();

                movieParcelable.setImg_movie(dataImgMovie.getResourceId(i, -1));
                movieParcelable.setTitle_movie(dataTitleMovie[i]);
                movieParcelable.setOverview_movie(dataOverviewMovie[i]);
                movieParcelable.setGendre_movie(dataGendreMovie[i]);
                movieParcelable.setRuntime_movie(dataRuntimeMovie[i]);
                movieParcelable.setBudget_movie(dataBudgetMovie[i]);
                movieParcelable.setRevenue_movie(dataRevenueMovie[i]);
                movieParcelable.setReview_movie(dataReviewMovie[i]);

                movieParcelableArrayList.add(movieParcelable);
            }

            adapter.setMovieParcelableArrayList(movieParcelableArrayList);

        }


}



